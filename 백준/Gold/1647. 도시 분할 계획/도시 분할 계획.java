import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[M][3];
        int[] parent = new int[N + 1];

        for (int i = 0; i <= N; i ++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[i][0] = a;
            graph[i][1] = b;
            graph[i][2] = c;
        }

        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        int calCost = kruskal(graph, parent, N, M);

        System.out.println(calCost);
    }

    private static int kruskal(int[][] graph, int[] parent, int N, int M) {
        int mstCost = 0;
        int maxCost = 0;

        for (int i = 0; i < M; i ++) {
            int a = graph[i][0];
            int b = graph[i][1];

            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                int c = graph[i][2];
                mstCost += c;
                maxCost = Math.max(maxCost, c);
            }
        }

        return mstCost - maxCost;
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    private static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x == y) return;

        if (x < y) {
            parent[y] = x;
        }
        else parent[x] = y;
    }
}