from typing import List, Dict
from bs4 import BeautifulSoup

import pickle
import requests
import aiohttp
import asyncio
import sys
import re


class Problem:
    """
    Represents a problem from the platforms
    """

    def __init__(self, id: str, title: str, url: str, platform: str):
        """
        - id : 문제 번호
        - title : 문제 이름
        - url : 사이트 내 문제 주소
        - platform : 플랫폼 이름
        """
        self.id = id
        self.title = title
        self.url = url
        self.platform = platform


class BaekjoonScraper:
    """
    A web scraper for the Baekjoon Online Judge.
    """
    BASE_URL = "https://www.acmicpc.net"
    API_URL = "https://solved.ac/api/v3"

    @staticmethod
    async def fetch(session: aiohttp.ClientSession, url: str, headers: Dict[str, str]) -> str:
        """
        Sends an HTTP GET request using the specified session, URL, and headers.
        Returns the response body as json.
        """
        try:
            async with session.get(url, headers=headers) as response:
                if response.status == 200:
                    return await response.json()
        except aiohttp.ClientError:
            print(f"Failed to fetch{url}")

    async def get_problem(self, problem_id: str) -> Problem:
        """
        Fetches the details for a single problem, given its ID.
        Returns a Problem object representing the problem.
        """
        api_url = f"{BaekjoonScraper.API_URL}/problem/show?problemId={problem_id}"
        headers = {"Content-Type": "application/json"}
        async with aiohttp.ClientSession() as session:
            response_json = await BaekjoonScraper.fetch(session, api_url, headers)
            # 파일 정보 확인
            problem_title = response_json['titleKo']
            problem_url = f"{BaekjoonScraper.BASE_URL}/problem/{problem_id}"
            return Problem(problem_id, problem_title, problem_url, "baekjoon")

    async def get_problems(self, problem_ids: List[str]) -> List[Problem]:
        """
        Fetches the details for multiple problems, given their IDs.
        Returns a list of Problem objects representing the problems.
        """
        tasks = [self.get_problem(re.sub(r"[^\d]", "", id))
                 for id in problem_ids]
        return await asyncio.gather(*tasks)


class ProgrammersScraper:
    """
    A web scraper for the Programmers.
    """
    BASE_URL = "https://programmers.co.kr/"
    API_URL = "https://school.programmers.co.kr/learn/courses/30/30-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%97%B0%EC%8A%B5"

    @staticmethod
    def fetch(session: requests.Session, url: str, headers: Dict[str, str]) -> str:
        """
        Sends an HTTP GET request using the specified session, URL, and headers.
        Returns the response body as json.
        """
        try:
            with session.get(url, headers=headers) as response:
                if response.status_code == 200:
                    return response.text
        except requests.exceptions.RequestException as e:
            print(f"Failed to fetch{url}")
            print(e)

    def get_problems(self, problem_titles: List[str]) -> List[Problem]:
        """
        Fetches the details for a single problem, given its ID.
        Returns a Problem object representing the problem.
        """
        api_url = f"{ProgrammersScraper.API_URL}"
        headers = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.50", }
        with requests.Session() as session:
            response_html = ProgrammersScraper.fetch(session, api_url, headers)
            soup = BeautifulSoup(response_html, "html.parser")
            texts = soup.select(".lesson-title")
            # 결과 저장
            problems = []
            for text in texts:
                problem_id = text['href'].split("/")[-1]
                # 공백 / 줄바꿈 제거
                problem_title = re.sub(r'\n', '', text.text)
                problem_title = re.sub(r"^\s+", '', problem_title)
                problem_url = f"{ProgrammersScraper.BASE_URL}{text['href']}"
                if re.sub(r'\s', '', problem_title.split("/")[-1]) in problem_titles:
                    problems.append(
                        Problem(problem_id, problem_title, problem_url, "programmers"))
            return problems

# To - Do : Softeer 크롤러 구현하기


class SyncScraper:
    """
    Web scrapers in sync way
    """
    lst = {"programmers": ProgrammersScraper}

    def __init__(self, platforms):
        """
        플랫폼 별 크롤러 생성
        """
        self.scraper = {platform: SyncScraper.lst[platform](
        ) for platform in platforms if platform in SyncScraper.lst}

    def get_problems(self, problem_infos):
        return [scraper.get_problems(problem_infos[platform]) for platform, scraper in self.scraper.items()]


class ASyncScraper:
    """
    Web scrapers in async way
    """
    lst = {"baekjoon": BaekjoonScraper}

    def __init__(self, platforms):
        self.scraper = {platform: ASyncScraper.lst[platform](
        ) for platform in platforms if platform in ASyncScraper.lst}

    async def get_problems(self, problem_infos):
        tasks = [scraper.get_problems(problem_infos[platform])
                 for platform, scraper in self.scraper.items()]
        return await asyncio.gather(*tasks)


class Scraper:
    """
    Web scrapers
    """
    @staticmethod
    async def get_problems(problem_infos: Dict[str, List[str]]) -> List[Problem]:
        # 크롤러 생성
        sync_scraper = SyncScraper(tuple(problem_infos.keys()))
        async_scraper = ASyncScraper(tuple(problem_infos.keys()))
        # 문제 정보 저장
        problems = []
        if sync_scraper.scraper:
            problems.extend(sync_scraper.get_problems(problem_infos))
        if async_scraper.scraper:
            problems.extend(await async_scraper.get_problems(problem_infos))
        # 1차원으로 변경
        problems = sum(problems, [])
        return problems


def save_and_return_problems(problems: List[Problem]) -> Dict[str, List[str]]:
    """
    문제의 고유 정보 저장
    - problem_infos : {"baekjoon/1000" : [문제 이름, url], "programmers/다트" : [문제이름, url]}
    """
    problem_infos = {}
    for problem in problems:
        problem_key = f"{problem.platform}/{problem.title}" if problem.platform != "baekjoon" else f"{problem.platform}/{problem.id}"
        problem_infos[problem_key] = [problem.id, problem.title, problem.url]
    with open("problem_info", "wb") as file:
        pickle.dump(problem_infos, file)
    return problem_infos


def upsert_problems(problems: List[Problem]):
    """
    문제의 고유 정보 업데이트
    """
    # 새로 추가
    with open("problem_info", "rb") as file:
        problem_infos = pickle.load(file)
        for problem in problems:
            problem_key = f"{problem.platform}/{problem.title}" if problem.platform != "baekjoon" else f"{problem.platform}/{problem.id}"
            problem_infos[problem_key] = [
                problem.id, problem.title, problem.url]
            problem_infos.update(
                {problem_key: [problem.id, problem.title, problem.url]})
    # 저장
    with open("problem_info", "wb") as file:
        pickle.dump(problem_infos, file)


if __name__ == "__main__":
    # Windows의 aiohttp 오류 방지
    if sys.platform == "win32":
        asyncio.set_event_loop_policy(asyncio.WindowsSelectorEventLoopPolicy())
    problems = asyncio.run(Scraper.get_problems(
        {"baekjoon": ["1011", "1023", "1024"], "baekjoon2": ["1234", "1233", "1234"], "programmers": ["예산", "배달"]}))
    save_and_return_problems(problems)
