import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] colors = new char[N][M];
        for (int i = 0; i < N; i++) {
            colors[i] = br.readLine().toCharArray();
        }

        int[][] prefixB = new int[N + 1][M + 1];
        int[][] prefixW = new int[N + 1][M + 1];
        prefixSum(N, M, prefixB, colors, 'B');
        prefixSum(N, M, prefixW, colors, 'W');

        System.out.println(calMinPrefix(N, M, K, prefixB, prefixW));
    }

    private static int calMinPrefix(int N, int M, int K, int[][] prefixB, int[][] prefixW) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - K; i ++) {
            for (int j = 0; j <= M - K; j ++) {
                int changesForB = countChanges(i, j, K, prefixB, prefixW, true);
                int changesForW = countChanges(i, j, K, prefixB, prefixW, false);

                min = Math.min(min, Math.min(changesForB, changesForW));
            }
        }

        return min;
    }

    private static int countChanges(int i, int j, int K, int[][] prefixB, int[][] prefixW, boolean isFirstB) {
        if (isFirstB) {
            int totalB = getSum(prefixB, i, j, K);
            return Math.min(totalB, K * K - totalB);
        }
        else {
            int totalW = getSum(prefixW, i, j, K);
            return Math.min(totalW, K * K - totalW);
        }
    }

    private static int getSum(int[][] prefix, int x, int y, int K) {
        return prefix[x + K][y + K] - prefix[x + K][y] - prefix[x][y + K] + prefix[x][y];
    }

    private static void prefixSum(int N, int M, int[][] prefix, char[][] colors, char startChar) {
        for (int i = 1; i <= N; i ++) {
            for (int j = 1; j <= M; j ++) {
                int expected = ((i + j) % 2 == 0) ? startChar : (startChar == 'B' ? 'W' : 'B');
                int value = colors[i - 1][j - 1] == expected ? 0 : 1;
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + value;
            }
        }
    }
}
