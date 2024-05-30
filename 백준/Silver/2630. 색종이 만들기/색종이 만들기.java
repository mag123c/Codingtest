import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int blue = 0;
    private static int white = 0;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //1 blue, 0 white
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(board, 0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void recursive(int[][] board, int a, int b, int N) {
        if (N == 1 || matchBoardColor(board, a, b, N)) {
            if (board[a][b] == 1) blue++;
            else white++;
            return;
        }

        int newN = N / 2;
        recursive(board, a, b, newN);
        recursive(board, a, b + newN, newN);
        recursive(board, a + newN, b, newN);
        recursive(board, a + newN, b + newN, newN);
    }

    private static boolean matchBoardColor(int[][] board, int a, int b, int N) {
        for (int i = a; i < a + N; i ++) {
            for (int j = b; j < b + N; j ++) {
                if (board[i][j] != board[a][b]) {
                    return false;
                }
            }
        }

        return true;
    }
}