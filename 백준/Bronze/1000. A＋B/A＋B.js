const fs = require("fs");
const input = fs.readFileSync("dev/stdin").toString();
const answer = input.split(" ").reduce((acc, cur) => acc + parseInt(cur), 0);
console.log(answer);
