import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i ++) {
            dp[i][0] = 1;

            for (int j = 0; j < i; j ++) {
                if (arr[i] > arr[j] && dp[j][0] >= dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                }
            }
        }

        for (int i = N - 1; i >= 0; i --) {
            dp[i][1] = 1;

            for (int j = N - 1; j >= i; j --) {
                if (arr[i] > arr[j] && dp[j][1] >= dp[i][1]) {
                    dp[i][1] = dp[j][1] + 1;
                }
            }
        }


        int answer = 0;
        for (int i = 0; i < N; i ++) {
            answer = Math.max(answer, dp[i][0] + dp[i][1] - 1);
        }

        System.out.println(answer);
    }
}