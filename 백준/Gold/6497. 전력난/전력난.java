import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) break;

            int[] parent = new int[m];

            for (int i = 0; i < m; i ++) {
                parent[i] = i;
            }

            int totalCost = 0;
            int useCost = 0;
            int[][] graph = new int[n][3];

            for (int i = 0; i < n; i ++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                graph[i][0] = x;
                graph[i][1] = y;
                graph[i][2] = z;            
            }
            
            Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
            
            for (int i = 0; i < n; i ++) {
                int x = graph[i][0];
                int y = graph[i][1];
                int z = graph[i][2];

                totalCost += z;
                
                if (find(parent, x) != find(parent, y)) {
                    union(parent, x, y);
                    useCost += z;
                }
            }

            bw.write(String.valueOf(totalCost - useCost + "\n"));
        }

        bw.flush();
        bw.close();

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
