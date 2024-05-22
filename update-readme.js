const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

const readmePath = 'README.md';

const getCommitMessages = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    return output;
};

const commitMessage = getCommitMessages();
const problemMatch = commitMessage.match(/\[(.*?)\] Title: (.*?), Time:/);

if (!problemMatch) {
    console.error('Commit message format is incorrect.');
    process.exit(1);
}

const problemLevel = problemMatch[1];
const problemTitle = problemMatch[2];

// 현재 커밋에 포함된 파일에서 문제 링크 추출
const getProblemLinkFromCommit = () => {
    const output = execSync('git show --name-only --oneline -1').toString().trim();
    const files = output.split('\n').slice(1); // 첫 줄은 커밋 메시지이므로 제외

    for (const file of files) {
        if (file.includes('README.md')) continue; // README.md 파일은 무시
        const fileContent = execSync(`git show HEAD:${file}`).toString();
        const match = fileContent.match(/\[문제 링크\]\((https:\/\/www\.acmicpc\.net\/problem\/\d+)\)/);
        if (match) {
            return match[1];
        }
    }

    return null;
};

const problemLink = getProblemLinkFromCommit();

if (!problemLink) {
    console.error('Problem link not found in the commit files.');
    process.exit(1);
}

const formattedCommitMessage = `[${problemLevel}] ${problemTitle} (${problemLink})`;

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
