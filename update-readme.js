const fs = require('fs');
const execSync = require('child_process').execSync;

const readmePath = 'README.md';
const linkFilePath = 'link.txt';

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

// link.txt 파일에서 문제 링크를 읽어오는 함수
const getProblemLink = () => {
    if (fs.existsSync(linkFilePath)) {
        return fs.readFileSync(linkFilePath, 'utf8').trim();
    } else {
        console.error('link.txt not found.');
        process.exit(1);
    }
};

const problemLink = getProblemLink();

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

const uploadedFiles = logUploadedFiles();

const updateReadme = () => {
    let content = '';
    const newEntry = {
        date: new Date().toISOString().slice(0, 10),
        title: problemTitle,
        level: problemLevel,
        link: problemLink
    };

    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf8');
    }

    const tableHeader = `
| #  | 날짜 | 문제 | 난이도 |
|:---:|:---:|:---:|:---:|
`;

    let tableContent = '';
    const existingEntries = content.split('\n').slice(2); // 기존의 테이블 내용을 가져옵니다.
    let index = 1;

    // 기존의 테이블 내용을 새로운 내용으로 업데이트합니다.
    for (const entry of existingEntries) {
        if (entry.trim()) {
            tableContent += `${entry}\n`;
            index++;
        }
    }

    tableContent += `| ${index} | ${newEntry.date} | [${newEntry.title}](${newEntry.link}) | ${getDifficultyIconPath(newEntry.level)} |`;
    fs.writeFileSync(readmePath, `${tableHeader}${tableContent}`);
};

updateReadme();
