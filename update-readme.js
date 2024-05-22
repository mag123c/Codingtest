const fs = require('fs');
const execSync = require('child_process').execSync;

const today = new Date().toISOString().slice(0, 10).replace(/-/g, '.');

const readmePath = 'README.md';

const getCommitMessages = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();

    if (!output.includes('-BaekjoonHub')) {
        console.error('This commit is not from BaekjoonHub.');
        process.exit(1);
    }

    const problemInfoMatch = output.match(/\[(.*?)\] Title: (.*?), Time:/);
    
    if (!problemInfoMatch) {
        console.error('Commit message format is incorrect.');
        process.exit(1);
    }
    
    const problemLevel = problemInfoMatch[1];
    const problemTitle = problemInfoMatch[2];

    return `[${problemLevel}] ${problemTitle}`;
};

const commitMessage = getCommitMessages();

// // 현재 커밋의 README.md 전체 내용을 읽어오는 함수
// const getCurrentCommitReadmeContent = () => {
//     try {
//         // 현재 커밋에 추가된 README.md 파일의 경로를 가져옴
//         const filePath = execSync('git diff-tree --no-commit-id --name-only -r HEAD | grep README.md').toString().trim();
//         if (!filePath) {
//             console.error('No README.md found in the current commit.');
//             process.exit(1);
//         }
//         const output = execSync(`git show HEAD:${filePath}`).toString();
//         return output;
//     } catch (error) {
//         console.error('Failed to read README.md from the current commit.');
//         process.exit(1);
//     }
// };

// const newReadmeContent = getCurrentCommitReadmeContent();

const updateReadme = () => {
    let content = '';

    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf8');
    }

    const dateSectionRegex = new RegExp(`### ${today}`, 'g');
    const newEntry = `- ${commitMessage}<br>`;
    
    if (content.match(dateSectionRegex)) {
        content = content.replace(dateSectionRegex, match => `${match}<br>\n${newEntry}`);
    } else {
        content += `\n### ${today}<br>\n${newEntry}\n`;
    }

    // // 현재 커밋의 README.md 내용 추가
    // content += `\n\n${newReadmeContent}\n`;

    fs.writeFileSync(readmePath, content);
};

updateReadme();
