import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] cheeze;
    private static boolean[][] isVisit;
    private static int N;
    private static int M;
    private static int[] dx = new int[] {-1, 1, 0, 0};
    private static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheeze = new int[N][M];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j ++) {
                cheeze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;
        while(true) {
            isVisit = new boolean[N][M];
            checkOutSideIsZero();
            checkMeltingSpot();
            if(!melt()) break;
            hour++;
        }

        System.out.println(hour);

    }

    private static void checkOutSideIsZero() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i ++) {
                int newX = poll[0] + dx[i];
                int newY = poll[1] + dy[i];

                if (isAvailable(newX, newY) && !isVisit[newX][newY] && cheeze[newX][newY] == 0) {
                    isVisit[newX][newY] = true;
                    q.offer(new int[] {newX, newY});
                }
            }
        }
    }

    private static void checkMeltingSpot() {
        for (int i = 0;  i< N; i ++) {
            for (int j = 0; j < M; j ++) {
                if (isVisit[i][j] || cheeze[i][j] == 0) continue;

                int cnt = 0;
                for (int k = 0; k < 4; k ++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if (isAvailable(newX, newY) && isVisit[newX][newY] && cheeze[newX][newY] == 0) {
                        cnt++;
                    }
                }

                if (cnt >= 2) cheeze[i][j] = -1;
            }
        }
    }

    private static boolean melt() {
        boolean melt = false;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j ++) {
                if (cheeze[i][j] == -1) {
                    cheeze[i][j] = 0;
                    melt = true;
                }
            }
        }

        return melt;
    }

    private static boolean isAvailable(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}

