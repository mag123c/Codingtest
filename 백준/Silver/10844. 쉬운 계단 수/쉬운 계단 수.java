import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] stairs = new int[N][10];
        int mod = 1000000000;
        Arrays.fill(stairs[0], 1);
        stairs[0][0] = 0;

        dp(stairs, mod);
    }

    private static void dp(int[][] stairs, int mod) {
        for (int i = 1; i < stairs.length; i ++) {
            stairs[i][0] = stairs[i - 1][1] % mod;
            stairs[i][9] = stairs[i - 1][8] % mod;
            for (int j = 1; j < 9; j ++) {
                stairs[i][j] = (stairs[i - 1][j + 1] + stairs[i - 1][j - 1]) % mod;
            }
        }

        long answer = 0;
        for (int i : stairs[stairs.length - 1]) {
            answer += i;
        }
        System.out.println(answer % mod);
    }
}