const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

const readmePath = 'README.md';

const getCommitMessages = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    return output;
};

const getProblemLinkFromReadme = () => {
    const output = execSync('git show HEAD:README.md').toString();
    const match = output.match(/\[문제 링크\]\((https:\/\/www\.acmicpc\.net\/problem\/\d+)\)/);
    return match ? match[1] : null;
};

const commitMessage = getCommitMessages();
const problemMatch = commitMessage.match(/\[(.*?)\] Title: (.*?), Time:/);

if (!problemMatch) {
    console.error('Commit message format is incorrect.');
    process.exit(1);
}

const problemLevel = problemMatch[1];
const problemTitle = problemMatch[2];
const problemLink = getProblemLinkFromReadme();

if (!problemLink) {
    console.error('Problem link not found in the README.md.');
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
