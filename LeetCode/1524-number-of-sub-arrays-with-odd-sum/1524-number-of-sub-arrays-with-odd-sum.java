class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0;
        int evenCount = 1;
        int prefixSum = 0;
        int result = 0;
        final int modulo = 1000000007;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 1) {
                result = (result + evenCount) % modulo;
                oddCount++;
            } else {
                result = (result + oddCount) % modulo;
                evenCount++;
            }
        }

        return result;
    }

    public boolean isOdd(int x) {
        return x % 2 == 1;
    }
}