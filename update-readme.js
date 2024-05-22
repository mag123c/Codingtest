const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

const getCommitMessage = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    return output.replace(' -BaekjoonHub', '');
};

const getChangedFiles = () => {
    const output = execSync('git diff-tree --no-commit-id --name-only -r HEAD').toString().trim();
    return output.split('\n');
};

const extractProblemLink = (readmeContent) => {
    const problemLinkRegex = /\[문제 링크\]\((https?:\/\/[^\s)]+)\)/;
    const match = readmeContent.match(problemLinkRegex);
    return match ? match[1] : null;
};

const updateReadme = (commitMessage, problemLink, readmeFilePath) => {
    let content = '';

    if (fs.existsSync(readmeFilePath)) {
        content = fs.readFileSync(readmeFilePath, 'utf8');
    }

    const newEntry = `- [${commitMessage}](${problemLink})\n`;
    const dateSectionRegex = new RegExp(`(### ${today}(<br>)?\n)`, 'g');

    if (content.match(dateSectionRegex)) {
        content = content.replace(dateSectionRegex, `$1${newEntry}`);
    } else {
        content = `### ${today}<br>\n${newEntry}\n` + content;
    }

    console.log('Updated README content:', content);  // 디버깅 출력
    fs.writeFileSync(readmeFilePath, content);
};

const commitMessage = getCommitMessage();
const changedFiles = getChangedFiles();

changedFiles.forEach(filePath => {
    if (filePath.endsWith('README.md')) {
        const readmeContent = fs.existsSync(filePath) ? fs.readFileSync(filePath, 'utf8') : '';
        const problemLink = extractProblemLink(readmeContent);

        if (problemLink) {
            updateReadme(commitMessage, problemLink, filePath);
        } else {
            console.error(`Problem link not found in ${filePath}`);
        }
    }
});
