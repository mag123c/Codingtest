import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[][] tetromino;
    private static boolean[][] bl;
    private static int[] x = new int[]{1, -1, 0, 0};
    private static int[] y = new int[]{0, 0, 1, -1};
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tetromino = new int[N][M];
        bl = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                tetromino[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j =0; j < M; j++) {
                bl[i][j] = true;
                int sum = 0;
                dfs(i, j, 1, tetromino[i][j]);
                bl[i][j] = false;
                fuck(i, j);
            }
        }
        System.out.println(max);
    }

    private static void dfs(int i, int j, int cnt, int sum) {
        if(cnt == 4) {
            max = Math.max(sum, max);
            return;
        }

        for(int k = 0; k < 4; k++) {
            int xx = j + x[k];
            int yy = i + y[k];

            if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
            if(bl[yy][xx]) continue;

            bl[yy][xx] = true;
            dfs(yy, xx, cnt + 1, sum + tetromino[yy][xx]);
            bl[yy][xx] = false;
        }
    }

    private static void fuck(int i, int j) {
        if (i < N - 2 && j < M - 1)
            max = Math.max(max, tetromino[i][j] + tetromino[i + 1][j] + tetromino[i + 2][j] + tetromino[i + 1][j + 1]);

        if (i < N - 2 && j > 0)
            max = Math.max(max, tetromino[i][j] + tetromino[i + 1][j] + tetromino[i + 2][j] + tetromino[i + 1][j - 1]);

        if (i < N - 1 && j < M - 2)
            max = Math.max(max, tetromino[i][j] + tetromino[i][j + 1] + tetromino[i][j + 2] + tetromino[i + 1][j + 1]);

        if (i > 0 && j < M - 2)
            max = Math.max(max, tetromino[i][j] + tetromino[i][j + 1] + tetromino[i][j + 2] + tetromino[i - 1][j + 1]);
    }
}