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
    try {
        return decodeURIComponent(filePath.replace(/\\x/g, '%'));
    } catch (error) {
        console.error('Failed to decode file path:', filePath, error);
        return filePath;
    }
};

const uploadedFiles = logUploadedFiles().map(decodeFilePath);

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
    const newEntry = {
        date: new Date().toISOString().slice(0, 10).replace(/-/g, '.'),
        title: problemTitle,
        level: problemLevel
    };
    const problemLink = await fetchProblemLink(problemTitle);
    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf8');
    }
    const tableHeader = `
| #  | 날짜 | 문제 | 난이도 |
|:---:|:---:|:---:|:---:|
`;

    const newTableRow = `| 1 | ${newEntry.date} | [${newEntry.title}](${problemLink}) | ${getDifficultyIconPath(newEntry.level)} |`;

    if (!content.includes(tableHeader)) {
        // README.md에 처음으로 테이블을 추가하는 경우
        content += `${tableHeader}${newTableRow}\n`;
    } else {
        const lines = content.split('\n');
        const currentMonth = newEntry.date.slice(0, 7);
        let lastTableIndex = -1;
        let lastTableMonth = '';

        for (let i = lines.length - 1; i >= 0; i--) {
            if (lines[i].startsWith('|') && lines[i].includes('|')) {
                const date = lines[i].split('|')[2].trim();
                const month = date.slice(0, 7);
                if (month === currentMonth) {
                    lastTableIndex = i;
                    lastTableMonth = month;
                    break;
                } else if (month < currentMonth) {
                    break;
                }
            }
        }

        if (lastTableIndex !== -1) {
            // 같은 달의 테이블이 존재하는 경우
            const tableLines = lines.slice(0, lastTableIndex + 1);
            const tableContent = lines.slice(lastTableIndex + 1);
            const tableCount = tableLines.filter(line => line.startsWith('|') && line.includes('|')).length;
            const newRow = `| ${tableCount + 1} | ${newEntry.date} | [${newEntry.title}](${problemLink}) | ${getDifficultyIconPath(newEntry.level)} |`;

            lines.splice(lastTableIndex + 1, 0, newRow);
            content = lines.join('\n');
        } else {
            // 새로운 달의 테이블을 추가해야 하는 경우
            let lastMonthIndex = lines.findIndex(line => line.startsWith('<details>'));

            if (lastMonthIndex !== -1) {
                const endIndex = lines.findIndex((line, idx) => idx > lastMonthIndex && line.startsWith('</details>'));
                const oldContent = lines.slice(0, lastMonthIndex).join('\n');
                const oldDetails = lines.slice(lastMonthIndex, endIndex + 1).join('\n');
                const newContent = `${oldContent}\n<details>\n<summary>${lastTableMonth} 풀이 목록</summary>\n\n${tableHeader}${oldDetails}\n</details>\n\n${tableHeader}${newTableRow}\n`;

                content = newContent;
            } else {
                // 접은글이 없는 경우
                const oldContent = lines.join('\n');
                const newContent = `${oldContent}\n\n${tableHeader}${newTableRow}\n`;

                content = newContent;
            }
        }
    }

    fs.writeFileSync(readmePath, content);
};

const logReadmeContents = () => {
    uploadedFiles.forEach(file => {
        console.log("File :", file);
        const decodedFile = decodeFilePath(file);
        console.log("Decode : ", decodedFile);
        if (decodedFile.endsWith('README.md')) {
            console.log(`Contents of ${decodedFile}:`);
            try {
                const readmeContent = fs.readFileSync(decodedFile, { encoding: 'utf8' });
                console.log(readmeContent);
            } catch (error) {
                console.error(`Error reading ${decodedFile}: ${error.message}`);
            }
        }
    });
};

(async () => {
    await updateReadme();
    logReadmeContents();
})();
