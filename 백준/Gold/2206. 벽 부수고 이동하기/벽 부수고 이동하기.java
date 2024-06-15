import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] miro = new int[N][M];
        String line;

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(miro, N, M);
        System.out.println(result);
    }

    private static int bfs(int[][] miro, int N, int M) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});

        int[][][] dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j][0] = Integer.MAX_VALUE;
                dist[i][j][1] = Integer.MAX_VALUE;
            }
        }
        dist[0][0][0] = 1;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int wallBroken = current[2];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                    if (miro[newX][newY] == 0 && dist[newX][newY][wallBroken] == Integer.MAX_VALUE) {
                        dist[newX][newY][wallBroken] = dist[x][y][wallBroken] + 1;
                        q.offer(new int[]{newX, newY, wallBroken});
                    } else if (miro[newX][newY] == 1 && wallBroken == 0 && dist[newX][newY][1] == Integer.MAX_VALUE) {
                        dist[newX][newY][1] = dist[x][y][wallBroken] + 1;
                        q.offer(new int[]{newX, newY, 1});
                    }
                }
            }
        }

        int result = Math.min(dist[N - 1][M - 1][0], dist[N - 1][M - 1][1]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
