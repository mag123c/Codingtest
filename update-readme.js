const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

const readmePath = 'README.md';

const getCommitMessages = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    const lines = output.split('\n');
    const titleLine = lines[0]; // 첫 번째 줄이 제목
    const linkLine = lines[1]; // 두 번째 줄이 링크
    return { titleLine, linkLine };
};

const commitMessages = getCommitMessages();
const commitMessage = `[[${commitMessages.titleLine}](${commitMessages.linkLine})]`;

const updateReadme = () => {
    let content = '';

    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf8');
    }

    const dateSectionRegex = new RegExp(`### ${today}`, 'g');
    if (content.match(dateSectionRegex)) {
        content = content.replace(dateSectionRegex, match => `${match}<br>\n- ${commitMessage}`);
    } else {
        content += `\n### ${today}<br>\n- ${commitMessage}\n`;
    }

    fs.writeFileSync(readmePath, content);
};

updateReadme();
