class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;
        int curMax = 0;
        int curMin = 0;

        for (int num: nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(curMax, maxSum);

            curMin = Math.min(curMin + num, num);
            minSum = Math.min(curMin, minSum);
        }

        return Math.abs(minSum) > maxSum ? Math.abs(minSum) : maxSum;
    }
}