const fs = require('fs');
const execSync = require('child_process').execSync;

const linkFilePath = 'link.txt';

// 현재 커밋의 README.md 파일에서 문제 링크를 추출하는 함수
const getProblemLinkFromCommit = () => {
    try {
        // 현재 커밋에서 변경된 파일 목록을 가져옴
        const output = execSync('git diff-tree --no-commit-id --name-only -r HEAD').toString().trim();
        const files = output.split('\n');

        // README.md 파일을 찾아서 문제 링크를 추출
        for (const file of files) {
            if (file.endsWith('README.md')) {
                const readmeContent = execSync(`git show HEAD:${file}`).toString();
                const match = readmeContent.match(/\[문제 링크\]\((https:\/\/www\.acmicpc\.net\/problem\/\d+)\)/);
                if (match) {
                    fs.writeFileSync(linkFilePath, match[1]);
                    return match[1];
                }
            }
        }
        console.error('No README.md found in the current commit.');
        process.exit(1);
    } catch (error) {
        console.error('Failed to read README.md from the current commit.');
        process.exit(1);
    }
};

// 문제 링크 추출 실행
getProblemLinkFromCommit();
