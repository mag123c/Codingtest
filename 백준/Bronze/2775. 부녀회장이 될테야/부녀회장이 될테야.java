import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i ++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k + 1][n + 1];

            for (int j = 1; j <= n; j ++) {
                dp[0][j] = j;
            }

            for (int f = 1; f <= k; f ++) {
                for (int r = 1; r <= n; r ++) {
                    dp[f][r] = dp[f][r - 1] + dp[f - 1][r];
                }
            }

            System.out.println(dp[k][n]);
        }
    }
}
