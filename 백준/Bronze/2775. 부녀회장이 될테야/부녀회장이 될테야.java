import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i ++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] apt = new int[k + 1][n + 1];

            dp(k, n, apt);
            System.out.println(apt[k][n]);        }
    }

    private static void dp(int k, int n, int[][] apt) {
        for (int i = 1; i <= n; i ++) {
            apt[0][i] = i;
        }

        for (int i = 1; i <= k; i ++) {
            for (int j = 1; j <= n; j ++) {
                apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
            }
        }
    }
}