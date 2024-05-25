import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] bag = new int[N][2];
        for (int i = 0; i  < N; i ++) {
            st = new StringTokenizer(br.readLine());

            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];

        int w;
        int v;
        for (int i = 1; i <= N; i ++) {
            w = bag[i - 1][0];
            v = bag[i - 1][1];

            //무게가 J인 배낭에 I번째가 들어가려할 때,
            for (int j = 0; j <= K; j++) {
                //무게 초과
                if (j < w) {
                    dp[i][j] = dp[i - 1][j];
                }
                //넣을 수 있다면, 이전벨류
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);

            }
        }

        System.out.println(dp[N][K]);
    }

}


