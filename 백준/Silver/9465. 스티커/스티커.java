import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int T;

    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i ++) {
            T = Integer.parseInt(br.readLine());
            dp = new int[2][T];

            for(int j = 0; j < 2; j ++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < T; k ++) {
                    dp[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j = 1; j < T; j ++) {
                dp[0][j] += j == 1 ? dp[1][j - 1] : Math.max(dp[1][j - 2], dp[1][j - 1]);
                dp[1][j] += j == 1 ? dp[0][j - 1] : Math.max(dp[0][j - 2], dp[0][j - 1]);
            }
            System.out.println(Math.max(dp[0][T - 1], dp[1][T - 1]));
        }

    }
}
