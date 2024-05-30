import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int zero;
    private static int minus;
    private static int plus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] paper = new int[N][N];

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(paper, 0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void recursive(int[][] paper, int a, int b, int N) {
        if (N == 1 || isAllMatches(paper, a, b, N)) {
            int curPaper = paper[a][b];
            if (curPaper == -1) minus++;
            else if (curPaper == 0) zero++;
            else plus++;
            return;
        }

        int newN = N / 3;

        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                recursive(paper, a + i * newN, b + j * newN, newN);
            }
        }
    }

    private static boolean isAllMatches(int[][] paper, int a, int b, int N) {
        int cur = paper[a][b];
        for (int i = a; i < a + N; i ++) {
            for (int j = b; j < b + N; j ++) {
                if (cur != paper[i][j]) return false;
            }
        }
        return true;
    }
}
