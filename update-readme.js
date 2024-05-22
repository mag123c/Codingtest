const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

const readmePath = 'README.md';

// 마지막 커밋 메시지 가져오기
const getCommitMessage = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    return output.replace(' -BaekjoonHub', '');
};

// 마지막 커밋에서 변경된 파일 경로 가져오기
const getChangedFiles = () => {
    const output = execSync('git diff-tree --no-commit-id --name-only -r HEAD').toString().trim();
    return output.split('\n').filter(file => file !== readmePath);
};

// 변경된 파일 경로를 바탕으로 문제 정보 추출하기
const extractProblemInfo = (filePath) => {
    const parts = filePath.split('/');
    const titleWithExtension = parts.pop();
    const title = titleWithExtension.replace('.md', '');
    const site = parts.shift();
    const problemNumber = parts.join('/');
    let siteUrl;

    if (site === '백준') {
        siteUrl = `https://www.acmicpc.net/problem/${problemNumber}`;
    } else if (site === '프로그래머스') {
        siteUrl = `https://programmers.co.kr/learn/courses/30/lessons/${problemNumber}`;
    }

    return `- [[${title}]](${siteUrl})`;
};

const commitMessage = getCommitMessage();
const changedFiles = getChangedFiles();

const updateReadme = () => {
    let content = '';

    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf8');
    }

    const dateSectionRegex = new RegExp(`### ${today}`, 'g');
    const newEntries = changedFiles.map(extractProblemInfo).join('<br>\n');

    if (content.match(dateSectionRegex)) {
        content = content.replace(dateSectionRegex, match => `${match}<br>\n${newEntries}`);
    } else {
        content += `\n### ${today}<br>\n${newEntries}\n`;
    }

    fs.writeFileSync(readmePath, content);
};

updateReadme();
