import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] newMap;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        newMap = new int[N][M];
        int x = 0;
        int y = 0;

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                newMap[i][j] = -1;
                if(map[i][j] == 2) {
                    x = j;
                    y = i;
                }
                if(map[i][j] == 0 || map[i][j] == 2) newMap[i][j] = 0;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        bfs(queue);

        for(int i = 0; i < N; i ++) {
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < M; j ++) {
                sb.append(newMap[i][j] + " ");
            }
            System.out.println(sb.toString());
        }
    }

    private static void bfs(Queue<int[]> queue) {
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            for(int i = 0 ; i < size; i ++) {
                int[] now = queue.poll();

                for(int j = 0; j < 4; j ++) {
                    int newX = now[1] + dx[j];
                    int newY = now[0] + dy[j];

                    if(newX < 0 || newX >= M || newY < 0 || newY >= N) continue;

                    if(map[newY][newX] == 1 && !visited[newY][newX]) {
                        queue.offer(new int[]{newY, newX});
                        visited[newY][newX] = true;
                        newMap[newY][newX] = cnt;
                    }
                }
            }
        }
    }
}