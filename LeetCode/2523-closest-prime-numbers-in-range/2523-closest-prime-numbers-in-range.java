class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = eratosthenes(right);

        int distance = right;
        int min = -1;
        int max = -1;

        while(left <= right) {
            if (isPrime[left]) {
                for (int j = left + 1; j <= right; j++) {
                    if (isPrime[j]) {
                        if (distance > j - left) {
                            distance = j - left;
                            min = left;
                            max = j;
                        }
                        left = j;
                        break;
                    }
                }
            }
            left++;
        }

        return new int[] {min, max};
    }


    public boolean[] eratosthenes(int number) {
        boolean[] isPrime = new boolean[number + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= number; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= number; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}