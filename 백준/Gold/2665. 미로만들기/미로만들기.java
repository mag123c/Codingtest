import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(board, N));
    }

    private static int bfs(int[][] board, int N) {
        Deque<int[]> q = new LinkedList<>();
        int[][] dist = new int[N][N];
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
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

                if (nX >= 0 && nX < N && nY >= 0 && nY < N) {
                    int newDist = dist[curX][curY];
                    if (newDist < dist[nX][nY]) {
                        if (board[nX][nY] == 0) {
                            q.offerLast(new int[] {nX, nY});
                            dist[nX][nY] = newDist + 1;
                        }
                        else {
                            q.offerFirst(new int[] {nX, nY});
                            dist[nX][nY] = newDist;
                        }
                    }
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}
