import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int node;
        int cost;
        public Node (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i ++) {
            for (int j = 0; j <= N; j ++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        List<List<Node>> city = new ArrayList<>();
        for (int i = 0; i <= N; i ++) {
            city.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            city.get(start).add(new Node(dest, cost));
        }

        int[] toX = new int[N + 1];
        int[] fromX = new int[N + 1];

        Arrays.fill(toX, Integer.MAX_VALUE);
        Arrays.fill(fromX, Integer.MAX_VALUE);

        dijkstra(city, toX, X);

        List<List<Node>> reverseCity = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            reverseCity.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            for (Node node : city.get(i)) {
                reverseCity.get(node.node).add(new Node(i, node.cost));
            }
        }
        dijkstra(reverseCity, fromX, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, toX[i] + fromX[i]);
        }

        System.out.println(max);
    }

    private static void dijkstra(List<List<Node>> city, int[] dist,int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] isVisit = new boolean[dist.length];
        dist[start] = 0;
        q.offer(new Node(start,0));

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int cur = curNode.node;

            if (!isVisit[cur]) {
                isVisit[cur] = true;

                for (Node node : city.get(cur)) {
                    if (!isVisit[node.node] && dist[node.node] > dist[cur] + node.cost) {
                        dist[node.node] = dist[cur] + node.cost;
                        q.offer(new Node(node.node, dist[node.node]));
                    }
                }
            }
        }
    }
}
