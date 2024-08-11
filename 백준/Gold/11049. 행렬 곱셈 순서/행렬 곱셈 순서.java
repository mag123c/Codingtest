import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                int tmp = j + i - 1;
                dp[j][tmp] = Integer.MAX_VALUE;

                for (int k = j; k < tmp; k++) {
                    int cost = dp[j][k] + dp[k + 1][tmp] + arr[j][0] * arr[k][1] * arr[tmp][1];
                    dp[j][tmp] = Math.min(dp[j][tmp], cost);
                }
            }
        }

        System.out.println(dp[0][N - 1]);

    }

}
