const fs = require('fs');
const path = require('path');
const execSync = require('child_process').execSync;

const readmePath = 'README.md';

// 오늘 날짜를 "YYYY.MM.DD" 형식으로 반환
const getToday = () => {
    const date = new Date();
    const yyyy = date.getFullYear();
    const mm = String(date.getMonth() + 1).padStart(2, '0');
    const dd = String(date.getDate()).padStart(2, '0');
    return `${yyyy}.${mm}.${dd}`;
};

const today = getToday();

const getCommitMessages = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    return output.replace(' -BaekjoonHub', '');
};

const commitMessages = getCommitMessages();

const updateReadme = () => {
    let content = '';

    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf-8');
    }

    // 오늘 날짜 섹션이 이미 있는지 확인
    const dateSectionRegex = new RegExp(`### ${today}`, 'g');
    if (content.match(dateSectionRegex)) {
        // 이미 존재하는 날짜 섹션에 추가
        content = content.replace(dateSectionRegex, match => `${match}<br>\n- ${commitMessages}`);
    } else {
        // 날짜 섹션이 없으면 새로 추가
        content = `### ${today}<br>\n- ${commitMessages}\n` + content;
    }

    fs.writeFileSync(readmePath, content);
};

updateReadme();
