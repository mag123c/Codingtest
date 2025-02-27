class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num: arr) { 
            set.add(num);
        }

        int max = 0;

        for (int i = 0; i < arr.length; i ++) {
            for (int j = i + 1; j < arr.length; j ++) {
                int x = arr[i];
                int y = arr[j];
                int length = 2;

                while (set.contains(x + y)) {
                    int prefixSum = x + y;
                    x = y;
                    y = prefixSum;
                    length ++;
                }

                max = Math.max(length, max);
            }
        }

        return max > 2 ? max : 0;
        
    }
}