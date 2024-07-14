import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] city = new int[N + 1][N + 1];
        int[] graph = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    union(graph, i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        boolean answer = true;

        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());

            if (find(graph, first) != find(graph, next)) {
                answer = false;
                break;
            }

        }

        if (answer) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static void union(int[] graph, int x, int y) {
        x = find(graph, x);
        y = find(graph, y);

        if (x < y) {
            graph[y] = x;
        } else
            graph[x] = y;
    }

    private static int find(int[] graph, int n) {
        if (graph[n] == n) {
            return n;
        }

        return graph[n] = find(graph, graph[n]);
    }
}
