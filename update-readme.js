const fs = require('fs');
const execSync = require('child_process').execSync;
const axios = require('axios');
const readmePath = 'README.md';

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

const fetchProblemLink = async (title) => {
    try {
        const reqUrl = `https://solved.ac/api/v3/search/problem?query=${title}&page=1`;
        const { data } = await axios.get(reqUrl);
        return `https://www.acmicpc.net/problem/${data.items[0].problemId}`;
    } catch (error) {
        console.error('Failed to fetch problem link:', error);
        return null;
    }
};

const updateReadme = async () => {
    let content = '';
    const defaultDiv = '<div align="center">\n\n';
    const newEntry = {
        date: new Date().toISOString().slice(0, 10).replace(/-/g, '.'),
        title: problemTitle,
        level: problemLevel
    };
    const problemLink = await fetchProblemLink(problemTitle);
    if (existsSync(readmePath)) {
        content = readFileSync(readmePath, 'utf8');
    }

    let curContent = content.replace(/<details[\s\S]*?<\/details>/gi, '').split("\r\n\r\n\r\n\r\n")[1];

    const detailsRegex = /<details[\s\S]*?<\/details>/gi;
    let detailsContent = content.match(detailsRegex) || [];
    if (detailsContent.length > 0) {
        detailsContent = detailsContent.map(detail => `${detail}\n\n`);
    }

    const curDate = parseLastDate(curContent);
    const curIdx = parseLastIdx(curContent);
    const tableHeader = `
| #  | 날짜 | 문제 | 난이도 |
|:---:|:---:|:---:|:---:|
`;

    if (newEntry.date.slice(5, 7) != curDate.slice(5, 7)) {
        const updateContent = `<details>\n<summary>${curDate.slice(0, 7)} 풀이 목록</summary>\n${curContent}\n</details>\n\n`;
        const newTableRow = `| ${1} | ${newEntry.date} | [${newEntry.title}](${problemLink}) | ${getDifficultyIconPath(newEntry.level)} |`;

        content = defaultDiv + detailsContent + updateContent + tableHeader + newTableRow + "\n";
    }
    else {
        const newTableRow = `| ${+curIdx + 1} | ${newEntry.date} | [${newEntry.title}](${problemLink}) | ${getDifficultyIconPath(newEntry.level)} |`;
        curContent = curContent + "\n" + newTableRow + "\n";
        content = defaultDiv + detailsContent + curContent;
        console.log(content);
    }

    writeFileSync(readmePath, content);
};

function parseLastDate(content) {
    const lines = content.split('\n').filter(line => line.trim() !== '');
    return lines[lines.length - 1].split("|")[2].trim();
}

function parseLastIdx(content) {
    const lines = content.split('\n').filter(line => line.trim() !== '');
    return lines[lines.length - 1].split("|")[1].trim();
}

updateReadme();
