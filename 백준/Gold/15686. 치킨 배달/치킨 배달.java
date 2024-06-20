import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static final int INF = Integer.MAX_VALUE;
    private static int[][] village;
    private static boolean[][] isVisit;
    private static int chickenCnt = 0;
    private static int minDist = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        village = new int[N][N];
        isVisit = new boolean[N][N];
        //0 빈칸, 1 집, 2 치킨집
        // 집 < 2N, M <= 치킨집 <= 13
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) {
                village[i][j] = Integer.parseInt(st.nextToken());
                if (village[i][j] == 2) chickenCnt++;
            }
        }

        backtracking(0, 0, 0);

        System.out.println(minDist);
    }

    private static void backtracking(int a, int b, int closeCnt) {
        if (chickenCnt - closeCnt == M) {
            minDist = Math.min(minDist, calculateMinDist());
            return;
        }

        for (int i = a; i < N; i ++) {
            for (int j = 0; j< N; j ++) {
                if (!isVisit[i][j] && village[i][j] == 2) {
                    isVisit[i][j] = true;
                    village[i][j] = 0;
                    backtracking(i, j, closeCnt + 1);
                    isVisit[i][j] = false;
                    village[i][j] = 2;
                }
            }
        }
    }

    private static int calculateMinDist() {
        int dist = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (village[i][j] == 1) {
                    dist += chickenDist(i, j);
                }
            }
        }

        return dist;
    }

    private static int chickenDist(int a, int b) {
        int dist = INF;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j++) {
                if (village[i][j] == 2) {
                    dist = Math.min(Math.abs(i - a) + Math.abs(j - b), dist);
                }
            }
        }

        return dist;
    }
}
