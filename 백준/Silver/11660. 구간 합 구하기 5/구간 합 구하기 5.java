import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i ++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 1; j <= N; j ++) {
                dp[i][j] = dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int j = x1; j <=x2; j ++) {
                sum += dp[j][y2] - dp[j][y1 - 1];
            }
            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}
