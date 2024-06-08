import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] miro = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(miro, N, M));
    }

    private static int bfs(int[][] miro, int N, int M) {
        Deque<int[]> q = new LinkedList<>();
        int[][] dist = new int[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        q.offer(new int[] {0, 0});
        dist[0][0] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i ++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M) {
                    int newDist = dist[curX][curY] + miro[nX][nY];
                    if (newDist < dist[nX][nY]) {
                        dist[nX][nY] = newDist;
                        if (miro[nX][nY] == 1) {
                            q.offerLast(new int[]{nX, nY});
                        } else {
                            q.offerFirst(new int[]{nX, nY});
                        }
                    }
                }
            }
        }

        return dist[N - 1][M - 1];

    }
}
