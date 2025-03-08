class Solution {
    public int minimumRecolors(String blocks, int k) {
        int length = blocks.length();

        int max = 100;
        for (int i = 0; i <= length - k; i ++) {
            long tmp = blocks.substring(i, k + i).chars().filter(c -> c == 'W').count();
            max = Math.min((int) tmp, max);
        }

        return max;
    }
}