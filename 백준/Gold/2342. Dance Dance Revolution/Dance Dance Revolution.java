import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] move;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = st.countTokens();
        move = new int[length - 1];
        for (int i = 0; i < length - 1; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[5][5][length - 1];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(solve(0, 0, 0) + "\n");
        bw.flush();
        bw.close();
    }

    private static int solve(int left, int right, int cnt) {
        if (cnt == move.length) return 0;

        if (dp[left][right][cnt] != -1) return dp[left][right][cnt];

        dp[left][right][cnt] = Math.min(
            solve(move[cnt], right, cnt + 1) + energy(left, move[cnt]),
            solve(left, move[cnt], cnt + 1) + energy(right, move[cnt])
        );

        return dp[left][right][cnt];
    }

    private static int energy(int pos, int des) {
        int num = Math.abs(pos - des);
        if (pos == 0) return 2;
        else if (num == 0) return 1;
        else if (num == 1 || num == 3) return 3;
        else return 4;
    }
}
