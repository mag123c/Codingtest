const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

const readmePath = 'README.md';

const getCommitMessage = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    console.log('Commit message:', output);  // 디버깅 출력
    return output.replace(' -BaekjoonHub', '');
};

const extractProblemLink = (readmeContent) => {
    const problemLinkRegex = /\[문제 링크\]\((https?:\/\/[^\s)]+)\)/;
    const match = readmeContent.match(problemLinkRegex);
    return match ? match[1] : null;
};

const updateReadme = (commitMessage, problemLink) => {
    let content = '';

    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf8');
    }

    const newEntry = `### ${today}<br>\n- [${commitMessage}](${problemLink})\n`;

    const dateSectionRegex = new RegExp(`### ${today}`, 'g');
    if (content.match(dateSectionRegex)) {
        content = content.replace(dateSectionRegex, match => `${match}<br>\n- [${commitMessage}](${problemLink})`);
    } else {
        content = newEntry + content;
    }

    fs.writeFileSync(readmePath, content);
};

const commitMessage = getCommitMessage();

const readmeFiles = execSync('find . -name "README.md"').toString().trim().split('\n');

readmeFiles.forEach(readmeFilePath => {
    const readmeContent = fs.existsSync(readmeFilePath) ? fs.readFileSync(readmeFilePath, 'utf8') : '';
    const problemLink = extractProblemLink(readmeContent);

    if (problemLink) {
        updateReadme(commitMessage, problemLink);
    } else {
        console.error(`Problem link not found in ${readmeFilePath}`);
    }
});
