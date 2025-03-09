class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int length = colors.length;
        int count = 1;
        for (int i = 1; i < k; i ++) {
            if (colors[i] != colors[i - 1]) count++;
        }

        int result = count == k ? 1 : 0;

        for (int i = 1; i < length; i ++) {
            int outIdx = i - 1;
            int inIdx = (k + i - 1) % length;

            if (colors[outIdx] != colors[(outIdx + 1) % length]) count--;
            if (colors[inIdx] != colors[(inIdx - 1 + length) % length]) count++;

            if (count == k) result++;
        }

        return result;
    }
}