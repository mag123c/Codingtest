import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[N];

        for (int i = 0; i < N; i ++) {
            dp[i] = 1;

            for(int j = 0; j < i; j ++) {
                if (line[i][1] > line[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        Arrays.sort(dp);

        System.out.println(N - dp[N - 1]);
    }
}


