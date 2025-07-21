import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i ++) {
            String[] testCase = br.readLine().split(" ");
            int west = Integer.parseInt(testCase[0]);
            int east = Integer.parseInt(testCase[1]);
            long[][] dp = new long[west + 1][east + 1];

            for (int j = 0; j <= east; j ++) {
                dp[1][j] = j;
            }

            for (int j = 2; j <= west; j ++) {
                for (int k = 1; k <= east; k ++) {
                    dp[j][k] = dp[j - 1][k - 1] + dp[j][k - 1];
                }
            }

            System.out.println(dp[west][east]);
        }
    }
}
