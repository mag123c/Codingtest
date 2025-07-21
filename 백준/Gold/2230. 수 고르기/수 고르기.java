import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] sequence = new int[N];
        for (int i = 0; i < N; i ++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(sequence);

        System.out.println(findMinDifferenceAtLeast(sequence, M));
    }

    public static int findMinDifferenceAtLeast(int[] sortedAscSequence, int M) {
        int left = 0;
        int right = 1;
        int minDiff = Integer.MAX_VALUE;

        while (right < sortedAscSequence.length) {
            int diff = sortedAscSequence[right] - sortedAscSequence[left];

            if (diff >= M) {
                minDiff = Math.min(minDiff, diff);
                if (diff == M) return M;
                left++;
            } else {
                right++;
            }
        }
        return minDiff;
    }
}
