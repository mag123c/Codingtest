class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] >= 0) break;
            neg++;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= 0) break;
            pos++;
        }

        return Math.max(pos, neg);
    }
}