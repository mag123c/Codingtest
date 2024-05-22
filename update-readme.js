const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

// Get the latest commit message without the " -BaekjoonHub" part
const getCommitMessage = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    return output.replace(' -BaekjoonHub', '');
};

// Get the list of files changed in the latest commit
const getChangedFiles = () => {
    const output = execSync('git diff-tree --no-commit-id --name-only -r HEAD').toString().trim();
    return output.split('\n');
};

// Extract the problem link from the README file (any URL)
const extractProblemLink = (readmeContent) => {
    const problemLinkRegex = /\[문제 링크\]\((https?:\/\/[^\s)]+)\)/;
    const match = readmeContent.match(problemLinkRegex);
    return match ? match[1] : null;
};

// Update the README file
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
