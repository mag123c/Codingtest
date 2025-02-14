class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length  - 1; i ++) {
            int current = nums[i];

            for (int j = i + 1; j < nums.length; j ++) {
               if (current + nums[j] == target) {
                   return new int[]{i, j};
               }

            }
        }

        return new int[] {0, 0};
    }
}