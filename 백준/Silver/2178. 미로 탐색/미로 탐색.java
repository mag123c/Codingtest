import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[][] miro;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i ++) {
            String s = br.readLine();
            for(int j = 0; j < M; j ++) {
                miro[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        bfs(queue);
    }

    private static void bfs(Queue<int[]> queue) {
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i ++) {
                int[] now = queue.poll();

                for(int j = 0; j < 4; j ++) {
                    int xx = now[1] + dx[j];
                    int yy = now[0] + dy[j];

                    if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;

                    if(miro[yy][xx] > 0 && !visited[yy][xx]) {
                        visited[yy][xx] = true;
                        miro[yy][xx] += miro[now[0]][now[1]];
                        queue.add(new int[] {yy, xx});
                    }
                }
            }
        }
        System.out.println(miro[N - 1][M - 1]);
    }

}
