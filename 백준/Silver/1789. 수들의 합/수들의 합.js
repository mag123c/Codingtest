const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim();
let count = 0;
while (input - count > 0) {
  count++;
  input -= count;
}
console.log(count);