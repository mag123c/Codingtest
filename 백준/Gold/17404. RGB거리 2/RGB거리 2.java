import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp(arr, N);

    }

    private static void dp(int[][] arr, int N) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int[][] dp = new int[N][3];
            for (int j = 0; j < 3; j++) {
                dp[0][j] = (j == i) ? arr[0][j] : 99999999;
            }

            for (int j = 1; j < N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }

            for (int j = 0; j < 3; j ++) {
                if (i != j) {
                    min = Math.min(min, dp[N - 1][j]);
                }
            }

        }

        System.out.println(min);
    }
}
