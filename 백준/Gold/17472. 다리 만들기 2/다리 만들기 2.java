import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Bridge {

        int start;
        int end;
        int cost;

        public Bridge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

    }

    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };

    // 1. 같은 선상 (꺾이면 안됨)
    // 2. 길이가 1 초과여야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandCnt = 0;
        int[][] islandsMap = new int[N][M];
        boolean[][] isVisit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !isVisit[i][j]) {
                    islandCnt++;
                    bfs(map, islandsMap, isVisit, N, M, i, j, islandCnt);
                }
            }
        }

        List<Bridge> bridges = findBridges(map, islandsMap, N, M);

        Collections.sort(bridges, (o1, o2) -> o1.cost - o2.cost);

        int[] parent = new int[islandCnt + 1];

        for (int i = 0; i < islandCnt + 1; i++) {
            parent[i] = i;
        }

        int mstCost = 0;

        for (Bridge b : bridges) {
            int s = b.start;
            int e = b.end;

            if (find(parent, s) != find(parent, e)) {
                union(parent, s, e);
                mstCost += b.cost;
            }
        }

        int root = find(parent, 1);

        for (int i = 2; i < islandCnt + 1; i ++) {
            if (find(parent, i) != root) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(mstCost == 0 ? -1 : mstCost);

    }

    private static int find(int[] parent, int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }

    private static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x == y)
            return;

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        } 
    }

    private static List<Bridge> findBridges(int[][] map, int[][] islandsMap, int N, int M) {
        List<Bridge> bridges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (islandsMap[i][j] > 0) {
                    int number = islandsMap[i][j];

                    for (int k = 0; k < 4; k++) {
                        int length = 0;
                        int x = i;
                        int y = j;

                        while (true) {
                            x += dx[k];
                            y += dy[k];

                            if (!isAvailableIdx(x, y, N, M) || islandsMap[x][y] == number
                                    || (length <= 1 && map[x][y] == 1))
                                break;

                            if (islandsMap[x][y] > 0 && length >= 2) {
                                bridges.add(new Bridge(number, islandsMap[x][y], length));
                                break;
                            }
                            length++;
                        }
                    }
                }
            }
        }

        return bridges;
    }

    private static void bfs(int[][] map, int[][] islandsMap, boolean[][] isVisit, int N, int M, int x, int y, int cnt) {
        isVisit[x][y] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { x, y });
        islandsMap[x][y] = cnt;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];

                if (isAvailableIdx(newX, newY, N, M) && !isVisit[newX][newY] && map[newX][newY] == 1) {
                    isVisit[newX][newY] = true;
                    islandsMap[newX][newY] = cnt;
                    que.offer(new int[] { newX, newY });
                }

            }
        }
    }

    private static boolean isAvailableIdx(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}
