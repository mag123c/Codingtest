import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static class Edge {
        int from, to, cost;

        private Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private static ArrayList<Edge> edgeList = new ArrayList<>();
    private static int[] dist;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            Arrays.fill(dist, INF);
            edgeList.clear();

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(S, E, T));
                edgeList.add(new Edge(E, S, T));
            }
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(S, E, -T));
            }

            if (bellmanFord(1, N)) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static boolean bellmanFord(int start, int N) {
        dist[start] = 0;

        // N-1번의 릴렉세이션(relaxation) 수행
        for (int i = 1; i < N; i++) {
            for (Edge edge : edgeList) {
                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }

        // 추가 릴렉세이션으로 음수 사이클 검증
        for (Edge edge : edgeList) {
            if (dist[edge.to] > dist[edge.from] + edge.cost) {
                return true; // 음수 사이클 존재
            }
        }

        return false; // 음수 사이클 존재하지 않음
    }
}
