class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] check = new int[(int) Math.pow(grid.length, 2) + 1];
        int dup = -1;
        int nf = -1;

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (check[grid[i][j]] > 0) {
                    dup = grid[i][j];
                }
                check[grid[i][j]]++;
            }
        }

        for (int i = 1; i < check.length; i ++) {
            if (check[i] == 0) {
                nf = i;
                break;
            }
        }

        return new int[] {dup, nf};
    }
}