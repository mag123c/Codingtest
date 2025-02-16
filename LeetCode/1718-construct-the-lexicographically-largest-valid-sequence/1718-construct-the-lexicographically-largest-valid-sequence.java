class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] arr = new int[n * 2 - 1];
        boolean[] used = new boolean[n + 1];
        if (dfs(arr, used, 0, n)) {
            return arr;
        }
        return arr;
    }

    static boolean dfs(int[] arr, boolean[] used, int idx, int n) {
        if (idx == arr.length) {
            return true;
        }

        if (arr[idx] != 0) {
            return dfs(arr, used, idx + 1, n);
        }

        for (int num = n; num >= 1; num--) {
            int j = idx + num;

            if (!used[num] && (num == 1 || (j < arr.length && arr[j] == 0))) {
                arr[idx] = num;
                if (num != 1) arr[j] = num;
                used[num] = true;

                if (dfs(arr, used, idx + 1, n)) {
                    return true;
                }

                arr[idx] = 0;
                if (num != 1) arr[j] = 0;
                used[num] = false;
            }
        }

        return false;
    }
}