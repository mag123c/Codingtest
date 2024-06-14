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
    private static long[] dist;
    private static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(A, B, C));
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        if(bellmanFord(1, N)) {
            System.out.println(-1);
            return;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i <= N; i ++) {
            long value = dist[i] == INF ? -1 : dist[i];
            bw.write(value + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean bellmanFord(int start, int N) {
        dist[start] = 0;

        // N-1번의 릴렉세이션(relaxation) 수행
        for (int i = 1; i < N; i++) {
            for (Edge edge: edgeList) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }

        // 추가 릴렉세이션으로 음수 사이클 검증
        for (Edge edge: edgeList) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                return true; // 음수 사이클 존재
            }
        }

        return false; // 음수 사이클 존재하지 않음
    }
}