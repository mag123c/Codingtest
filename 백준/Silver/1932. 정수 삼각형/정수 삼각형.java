import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;

    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];

        for(int i = 0; i < N; i ++) {
            st  = new StringTokenizer(br.readLine(), " ");
            int cnt = 0;

            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                dp[i][cnt] = num;
                cnt++;
            }
        }

        for(int i = N - 1; i > 0; i --) {
            for(int j = 0; j < i; j ++) {
                dp[i - 1][j] += Math.max(dp[i][j], dp[i][j + 1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}
