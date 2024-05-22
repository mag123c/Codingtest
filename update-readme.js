const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

// Get the latest commit message without the " -BaekjoonHub" part
const getCommitMessage = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    console.log('Commit message:', output); // 디버그 메시지 추가
    return output.replace(' -BaekjoonHub', '');
};

// Get the list of files changed in the latest commit
const getChangedFiles = () => {
    const output = execSync('git diff-tree --no-commit-id --name-only -r HEAD').toString().trim();
    console.log('Changed files:', output); // 디버그 메시지 추가
    return output.split('\n');
};

// Update the README file
const updateReadme = (commitMessage, readmeFilePath) => {
    let content = '';

    if (fs.existsSync(readmeFilePath)) {
        content = fs.readFileSync(readmeFilePath, 'utf8');
    }

    const newEntry = `- ${commitMessage}\n`;
    const dateSectionRegex = new RegExp(`(### ${today}(<br>)?\n)`, 'g');

    if (content.match(dateSectionRegex)) {
        content = content.replace(dateSectionRegex, `$1${newEntry}`);
    } else {
        content = `### ${today}<br>\n${newEntry}\n` + content;
    }

    fs.writeFileSync(readmeFilePath, content);
    console.log('README updated:', readmeFilePath); // 디버그 메시지 추가
};

const commitMessage = getCommitMessage();
const changedFiles = getChangedFiles();

changedFiles.forEach(filePath => {
    if (filePath.endsWith('README.md')) {
        updateReadme(commitMessage, filePath);
    }
});
