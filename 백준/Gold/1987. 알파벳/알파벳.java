import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int R;
    private static int C;
    private static char[][] board;
    private static boolean[][] isVisit;
    private static int[] alpa;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int maxM = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpa = new int[26];
        board = new char[R][C];
        isVisit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j ++) {
                board[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(maxM);
    }

    private static void dfs(int x, int y, int move) {
        if (!isRange(x, y) || isVisit[x][y] || alpa[board[x][y] - 'A'] > 0) return;

        isVisit[x][y] = true;
        alpa[board[x][y] - 'A']++;
        maxM = Math.max(maxM, move);

        for (int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny, move + 1);
        }

        isVisit[x][y] = false;
        alpa[board[x][y] - 'A'] --;
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}