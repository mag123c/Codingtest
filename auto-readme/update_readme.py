import sys
import re
import asyncio
import pickle

from const import MD_NAME, CONCAT_MD_HEADER, MD_HEADER, MD_DIFFICULTY, MD_S_CHARS
from crawler import Scraper, upsert_problems
from typing import List, Dict
from git import Repo


# 관리할 폴더
PLATFORMS = ["baekjoon", "programmers"]  # , "softeer"]

# git 활용
GIT_REPO = Repo.init("../")
GIT_BRANCH = GIT_REPO.active_branch
GIT_BASE_DIR = f"https://github.com/mag123c/Codingtest/blob/{GIT_REPO.head.commit}"


class FileInfo:
    def __init__(self, path: str, platform: str, is_sol: str, dt: str, difficulty: str, *title: List[str]):
        """
        파일 정보 저장
        - path : programmers/solved/파일명.py
        - platform : programmers
        - is_sol : solved/retry
        - dt : 최초 커밋 날짜
        - difficulty : 난이도
        - title : 파일명 -> 실제 문제명 + 하이퍼링크
        """
        self.path = path
        self.platform = platform
        self.is_sol = is_sol
        self.dt = dt
        self.difficulty = difficulty
        self.title = "".join(*title)

    @staticmethod
    def get_dt(path: str) -> str:
        """
        정렬 기준으로 사용할 최종 커밋 날짜 확인
        """
        dt = GIT_REPO.git.log("--follow", "--pretty=%cd",
                              "--date=format:%Y-%m-%d", path).split("\n")[0]
        return dt

    @staticmethod
    def get_FileInfos_by_platform(file_paths: List[str]) -> Dict[str, List['FileInfo']]:
        """"
        플랫폼 별 파일 정보 반환
        - {"baekjoon" : ["1001", "1002"], "programmers" : ["문제 1", "문제 2"]}
        """
        file_infos = {}
        for file_path in file_paths:
            # 문제 풀이 파일 정보만 저장하기
            if file_path[-2:] == "py":
                platform, is_sol, *file = file_path.split("/")
                if platform not in file_infos:
                    file_infos[platform] = []
                # 파일 이름 정보만 가져오기
                file = file[-1]
                dt = FileInfo.get_dt(file_path)
                # 특수 문자로 인해 변경해서 저장한 파일명 다시 되돌리기
                for s_char in MD_S_CHARS:
                    file = file.replace(s_char, MD_S_CHARS[s_char])
                file_infos[platform].append(
                    FileInfo(file_path, platform, is_sol, dt, file[:-3].split("_")[0], file[:-3].split("_")[1:]))
        return file_infos

    @staticmethod
    def modify_titles(file_infos: List['FileInfo'], problem_infos: Dict[str, List[str]]):
        """
        문제 이름 수정 및 하이퍼링크 적용
        - 실제 문제 이름과 달리 파일명엔 공백이 없음 -> 크롤링해서 받아온 이름 활용
        - 불필요한 단어 제거 : [1차], [2021년 ~~] 등의 패턴 제거
        """
        title_dict = {problem_key.replace(
            " ", ""): problem_info[1] for problem_key, problem_info in problem_infos.items()}
        url_dict = {problem_key.replace(
            " ", ""): problem_info[2] for problem_key, problem_info in problem_infos.items()}
        for file_info in file_infos:
            # 불필요한 단어 제거
            if file_info.platform == "baekjoon":
                file_info.title = re.sub(r"[^\d]", "", file_info.title)
            file_info.title, url = re.sub(
                r"^\[.+]", "", title_dict[f"{file_info.platform}/{file_info.title}"]), url_dict[f"{file_info.platform}/{file_info.title}"]
            file_info.title = file_info.title.lstrip()
            # 하이퍼 링크 추가
            file_info.title = f"[{file_info.title}]({url})"


class READMEUpdater:
    """
    REAMD 파일 작성기
    """
    @staticmethod
    def cnt_lines(platform: str) -> int:
        with open(f"../{platform}/{MD_NAME}", "r", encoding="UTF-8") as readme:
            return (len(readme.readlines()) - 3)

    @staticmethod
    def get_lines(file_infos: List[FileInfo], start_idx: int) -> str:
        """
        문제 풀이 정보 저장
        """
        file_infos.sort(key=lambda x: (x.dt))
        md_lines = []
        for idx, file_info in enumerate(file_infos):
            sol = '✔️' if file_info.is_sol == "solved" else '❌'
            md_lines.append(
                f"|{idx+1+start_idx}|{file_info.dt}|{file_info.title}|[Link]({GIT_BASE_DIR}/{file_info.path})|{MD_DIFFICULTY[file_info.difficulty.upper()]}|{sol}|")
        # 마크다운 테이블 형식
        return "\n".join(md_lines[::-1])  # 가장 최근에 푼 문제가 가장 상위에 작성되도록

    @staticmethod
    def update_readme(md_lines: str, platform: str):
        """
        플랫폼 별 README 파일 업데이트
        """
        with open(f"../{platform}/{MD_NAME}", "r+", encoding="UTF-8") as readme:
            lines = readme.readlines()
            header, prev_lines = lines[:3], lines[3:]
            # 제일 첫 줄로 이동
            readme.seek(0)
            readme.writelines(header)
            readme.writelines(md_lines)
            readme.write("\n")
            readme.writelines(prev_lines)

    @staticmethod
    def concat_readme(platforms: List[str]):
        """
        전체 README 파일 작성
        """
        with open(f"../{MD_NAME}", "w", encoding="UTF-8") as main_readme:
            # 헤더 내용
            main_readme.writelines(CONCAT_MD_HEADER)
            # 목차 작성
            for platform in platforms:
                main_readme.write(
                    f"- [{platform.capitalize()}](#{'-'.join(MD_HEADER[platform].split())})" + "\n")
            main_readme.write("---" + "\n")
            # 각 플랫폼 별 README 파일 불러와서 병합하기
            for platform in platforms:
                with open(f"../{platform}/{MD_NAME}", "r", encoding="UTF-8") as readme:
                    main_readme.write(readme.read() + "\n")
                    main_readme.write("---" + "\n")


def run_main() -> bool:
    """
    README 업데이트 진행
    - 성공 시 True, 실패 시 False 반환
    """
    # 윈도우 10 문제 해결
    if sys.platform == "win32":
        asyncio.set_event_loop_policy(asyncio.WindowsSelectorEventLoopPolicy())
    # 새로 commit된 File만 확인
    file_paths = GIT_REPO.git.diff(
        [f"origin/{GIT_BRANCH}..origin/{GIT_BRANCH}^"], name_only=True)
    file_paths = file_paths.split("\n")
    # # 문제 풀이와 관련된 파일만 불러오기
    file_paths = [file_path for file_path in file_paths if file_path.split(
        "/")[0] in PLATFORMS]
    file_infos_platform = FileInfo.get_FileInfos_by_platform(file_paths)
    # 커밋된 파일이 문제 풀이랑 상관 없는 경우 제외
    if not file_infos_platform:
        return False
    # 문제 정보 크롤링
    problems = asyncio.run(Scraper.get_problems({platform: [
        file_info.title for file_info in file_infos] for platform, file_infos in file_infos_platform.items()}))
    # 문제 정보 업데이트
    problem_infos = upsert_problems(problems)
    with open("problem_info", "rb") as file:
        problem_infos = pickle.load(file)
    # 문제 이름 수정
    FileInfo.modify_titles(
        sum(file_infos_platform.values(), []), problem_infos)
    # 각 플랫폼 별 풀이 내역 수정하기
    for platform, file_infos in file_infos_platform.items():
        start_idx = READMEUpdater.cnt_lines(platform)  # 신규 문제 idx 확인
        md_lines = READMEUpdater.get_lines(file_infos, start_idx)
        READMEUpdater.update_readme(md_lines, platform)
    # 전체 풀이 내역 작성하기
    READMEUpdater.concat_readme(PLATFORMS)
    return True


if __name__ == "__main__":
    # README 업데이트 성공 여부 확인
    condition = run_main()
    # Github Actions의 실행 조건 전달
    print(f"DO_UPDATE={condition}")
