const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

const readmePath = 'README.md';

const getCommitMessages = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    return output.replace(' -BakekjoonHub');
};

const commitMessages = getCommitMessages();
const commitMessage = commitMessages[0];

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
