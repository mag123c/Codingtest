const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

const readmePath = 'README.md';

const getCommitMessages = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    return output;
};

const commitMessages = getCommitMessages();
const commitMessage = commitMessages.split('\n')[0];

// 현재 커밋에 포함된 파일에서 문제 링크 추출
const getProblemLinkFromCommit = () => {
    const output = execSync('git show HEAD:README.md').toString();
    const match = output.match(/\[문제 링크\]\((https:\/\/www\.acmicpc\.net\/problem\/\d+)\)/);
    return match ? match[1] : null;
};

const problemLink = getProblemLinkFromCommit();

// 문제 제목 추출 (커밋 메시지의 첫 줄 사용)
const problemTitle = commitMessage.match(/Title: (.*?),/)[1];
const formattedCommitMessage = `[${problemTitle}](${problemLink})`;

const updateReadme = () => {
    let content = '';

    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf8');
    }

    const dateSectionRegex = new RegExp(`### ${today}`, 'g');
    const newEntry = `- ${formattedCommitMessage}<br>`;
    
    if (content.match(dateSectionRegex)) {
        content = content.replace(dateSectionRegex, match => `${match}<br>\n${newEntry}`);
    } else {
        content += `\n### ${today}<br>\n${newEntry}\n`;
    }

    fs.writeFileSync(readmePath, content);
};

updateReadme();
