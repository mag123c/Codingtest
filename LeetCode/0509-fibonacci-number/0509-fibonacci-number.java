class Solution {
    public int fib(int n) {
        if (n == 0) {
            return n;
        }

        int[] nums = new int[n + 1];
        nums[1] = 1;

        for (int i = 2; i <= n; i ++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        return nums[n];
    }
}