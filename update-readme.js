const fs = require('fs');
const execSync = require('child_process').execSync;

// 오늘 날짜를 "YYYY.MM.DD" 형식으로 반환
const getToday = () => {
    const date = new Date();
    const yyyy = date.getFullYear();
    const mm = String(date.getMonth() + 1).padStart(2, '0');
    const dd = String(date.getDate()).padStart(2, '0');
    return `${yyyy}.${mm}.${dd}`;
};

const today = getToday();

const readmePath = 'README.md';

// 마지막 커밋 메시지 가져오기
const getCommitMessage = () => {
    const output = execSync('git log -1 --pretty=%B').toString().trim();
    return output.replace(' -BaekjoonHub', '');
};

// 마지막 커밋에서 변경된 파일 경로 가져오기
const getChangedFiles = () => {
    const output = execSync('git diff-tree --no-commit-id --name-only -r HEAD').toString().trim();
    return output.split('\n').filter(file => file !== readmePath);
};

const commitMessage = getCommitMessage();
const changedFiles = getChangedFiles();

const updateReadme = () => {
    let content = '';

    if (fs.existsSync(readmePath)) {
        content = fs.readFileSync(readmePath, 'utf8');
    }

    // 오늘 날짜 섹션이 이미 있는지 확인
    const dateSectionRegex = new RegExp(`### ${today}`, 'g');
    const newEntry = changedFiles.map(file => `| ${file} | [링크](/${file}) |`).join('<br>\n- ');

    if (content.match(dateSectionRegex)) {
        // 이미 존재하는 날짜 섹션에 추가
        content = content.replace(dateSectionRegex, match => `${match}<br>\n- ${newEntry}`);
    } else {
        // 날짜 섹션이 없으면 새로 추가
        content = `### ${today}<br>\n- ${newEntry}\n` + content;
    }

    fs.writeFileSync(readmePath, content);
};

updateReadme();
