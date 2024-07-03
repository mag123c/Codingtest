import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] arr;
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        List<List<int[]>> fish = new ArrayList<>();
        int x = 0, y = 0;

        for (int i = 0; i <= 6; i ++) {
            fish.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) {
                int f = Integer.parseInt(st.nextToken());
                arr[i][j] = f;

                if (f >= 1 && f <= 6) {
                    fish.get(f).add(new int[]{i, j});
                }
                if (f == 9) {
                    x = i;
                    y = j;
                    arr[i][j] = 0;
                }
            }            
        }

        System.out.println(simulate(x,y));
    }

    private static int simulate(int x, int y) {
        int shark = 2;
        int eat = 0;
        int time = 0;

        while (true) {
            int[] target = bfs(x, y, shark);

            if (target[2] == -1) break;

            time += target[2];
            x = target[0];
            y = target[1];
            arr[x][y] = 0;
            eat += 1;

            if (eat == shark) {
                shark++;
                eat = 0;
            }
        }

        return time;
    }

    private static int[] bfs(int x, int y, int shark) {
        boolean[][] isVisit = new boolean[N][N];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
            return o1[2] - o2[2];
        });

        pq.offer(new int[] {x, y, 0});
        isVisit[x][y] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (arr[cur[0]][cur[1]] > 0 && arr[cur[0]][cur[1]] < shark) {
                return new int[] {cur[0], cur[1], cur[2]};
            }

            for (int i = 0; i < 4; i ++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= N || shark < arr[newX][newY] || isVisit[newX][newY]) {
                    continue;
                }
                isVisit[newX][newY] = true;
                pq.offer(new int[] {newX, newY, cur[2] + 1});
            }
        }

        return new int[] {-1, -1, -1};
    }
}
