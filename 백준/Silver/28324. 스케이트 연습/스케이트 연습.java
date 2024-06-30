import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] speed = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            speed[i] = Integer.parseInt(st.nextToken());
        }

        int cur = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (cur + 1 > speed[i]) {
                cur = speed[i];
            } else {
                cur++;
            }
            dp[i] = cur;
        }

        int max = 0;
        for (int i : dp) {
            max += i;
        }

        System.out.println(max);

    }
}
