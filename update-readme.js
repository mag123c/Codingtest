const fs = require('fs');
const execSync = require('child_process').execSync;

const readmePath = 'README.md';

// 문제 난이도에 해당하는 SVG 파일 경로를 반환하는 함수
const getDifficultyIconPath = (level) => {
    const difficultyLevels = {
        'Bronze V': 1,
        'Bronze IV': 2,
        'Bronze III': 3,
        'Bronze II': 4,
        'Bronze I': 5,
        'Silver V': 6,
        'Silver IV': 7,
        'Silver III': 8,
        'Silver II': 9,
        'Silver I': 10,
        'Gold V': 11,
        'Gold IV': 12,
        'Gold III': 13,
        'Gold II': 14,
        'Gold I': 15,
        'Platinum V': 16,
        'Platinum IV': 17,
        'Platinum III': 18,
        'Platinum II': 19,
        'Platinum I': 20,
        'Diamond V': 21,
        'Diamond IV': 22,
        'Diamond III': 23,
        'Diamond II': 24,
        'Diamond I': 25,
        'Ruby V': 26,
        'Ruby IV': 27,
        'Ruby III': 28,
        'Ruby II': 29,
        'Ruby I': 30
    };
    return `<div align="center"><img src="https://github.com/mag123c/Codingtest/blob/main/icon/${difficultyLevels[level] || 0}.svg" /></div>`;
};

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
    return { problemLevel, problemTitle };
};

const { problemLevel, problemTitle } = getCommitMessages();

// 현재 커밋에 포함된 파일 경로와 파일명을 로그에 출력하는 함수
const logUploadedFiles = () => {
    try {
        const output = execSync('git diff-tree --no-commit-id --name-only -r HEAD').toString().trim();
        const files = output.split('\n');
        console.log('Uploaded files:');
        files.forEach(file => console.log(file));
        return files;
    } catch (error) {
        console.error('Failed to get uploaded files from the current commit.');
        process.exit(1);
    }
};

const decodeFilePath = (filePath) => {
    const buffer = Buffer.from(filePath, 'binary');
    return buffer.toString('utf8');
};

const uploadedFiles = logUploadedFiles().map(decodeFilePath);

const updateReadme = () => {
    let content = '';
    const newEntry = {
        date: new Date().toISOString().slice(0, 10),
        title: problemTitle,
        level: problemLevel
    };
    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf8');
    }
    const tableHeader = `
| #  | 날짜 | 문제 | 난이도 |
|:---:|:---:|:---:|:---:|
`;

    let tableContent = '';
    const tableStartIndex = content.indexOf(tableHeader);
    let index = 1;

    if (tableStartIndex !== -1) {
        tableContent = content.slice(tableStartIndex + tableHeader.length).trim();
        const existingEntries = tableContent.split('\n').filter(entry => entry.startsWith('|'));
        index = existingEntries.length + 1;
        tableContent = existingEntries.join('\n');
    }

    const newTableRow = `| ${index} | ${newEntry.date} | ${newEntry.title} | ${getDifficultyIconPath(newEntry.level)} |`;

    const newContent = content.slice(0, tableStartIndex + tableHeader.length).trim() + `\n${tableContent}\n${newTableRow}\n`;

    fs.writeFileSync(readmePath, newContent);
};

// 변경된 README.md 파일의 내용을 로그에 출력하는 함수
const logReadmeContents = () => {
    uploadedFiles.forEach(file => {
        if (file.endsWith('README.md')) {
            console.log(`Contents of ${file}:`);
            try {
                const readmeContent = fs.readFileSync(file, { encoding: 'utf8' });
                console.log(readmeContent);
            } catch (error) {
                console.error(`Error reading ${file}: ${error.message}`);
            }
        }
    });
};

updateReadme();
logReadmeContents();
