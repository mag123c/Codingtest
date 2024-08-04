import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] c = new char[N][M];
        int[] parent = new int[N * M];
        boolean[][] isVisit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                c[i][j] = line.charAt(j);
                parent[i * M + j] = i * M + j;
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisit[i][j]) {
                    dfs(i, j, M, c, isVisit, parent);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < N * M; i++) {
            if (parent[i] == i) {
                count++;
            }
        }

        System.out.println(count);

    }

    private static void dfs(int x, int y, int M, char[][] c, boolean[][] isVisit, int[] parent) {
        isVisit[x][y] = true;
        int nx = x;
        int ny = y;
        switch (c[x][y]) {
            case 'D':
                nx = x + 1;
                break;
            case 'U':
                nx = x - 1;
                break;
            case 'L':
                ny = y - 1;
                break;
            case 'R':
                ny = y + 1;
                break;
        }

        int current = x * M + y;
        int next = nx * M + ny;

        if (!isVisit[nx][ny]) {
            dfs(nx, ny, M, c, isVisit, parent);
        }

        union(current, next, parent);
    }

    private static void union(int x, int y, int[] parent) {
        x = find(parent, x);
        y = find(parent, y);

        if (x == y)
            return;
        if (x < y) {
            parent[y] = x;
        } else
            parent[x] = y;
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent, parent[x]);
    }

}
