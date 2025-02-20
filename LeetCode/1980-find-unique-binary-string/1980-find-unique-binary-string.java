class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> numSet = new HashSet<>();
        
        for (String num : nums) {
            numSet.add(num);
        }

        for (int i = 0; i < (1 << n); i++) {
            String binary = Integer.toBinaryString(i);
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            if (!numSet.contains(binary)) {
                return binary;
            }
        }
        
        return "";
    }
}