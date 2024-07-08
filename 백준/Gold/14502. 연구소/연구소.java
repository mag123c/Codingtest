import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };
    private static Queue<int[]> dust = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num == 2) {
                    dust.offer(new int[] { i, j });
                }
            }
        }

        System.out.println(findMaxSafeArea(0, 0, 0));
    }

    private static int findMaxSafeArea(int x, int y, int wall) {
        if (wall == 3) {
            return findSafetyArea();
        }

        int maxArea = 0;
        for (int i = x; i < N; i++) {
            for (int j = (i == x ? y : 0); j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    maxArea = Math.max(maxArea, findMaxSafeArea(i, j, wall + 1));
                    map[i][j] = 0;
                }
            }
        }

        return maxArea;
    }

    private static int findSafetyArea() {
        Queue<int[]> queue = new LinkedList<>(dust);
        int[][] tmpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
        boolean[][] visited = new boolean[N][M];
        int count = queue.size();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isAvailable(nx, ny) && tmpMap[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    tmpMap[nx][ny] = 2;
                    count++;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }

        return countSafetyArea(tmpMap);

    }

    private static int countSafetyArea(int[][] tmpMap) {
        int cnt = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j ++) {
                if (tmpMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    

}