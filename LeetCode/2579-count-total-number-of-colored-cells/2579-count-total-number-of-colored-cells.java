class Solution {
    public long coloredCells(int n) {
        long tmp = 1;
        for (int i = 2; i <= n; i ++) {
            tmp += (i * 2) + n - 2;
        }
        return tmp;
    }
}