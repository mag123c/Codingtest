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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Node>> city = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            city.get(start).add(new Node(dest, cost));
        }

        int[] toX = dijkstra(city, N, X);

        List<List<Node>> reverseCity = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            reverseCity.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            for (Node node : city.get(i)) {
                reverseCity.get(node.node).add(new Node(i, node.cost));
            }
        }

        int[] fromX = dijkstra(reverseCity, N, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, toX[i] + fromX[i]);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(List<List<Node>> graph, int n, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.node;

            if (visited[curNode]) continue;
            visited[curNode] = true;

            for (Node neighbor : graph.get(curNode)) {
                if (dist[neighbor.node] > dist[curNode] + neighbor.cost) {
                    dist[neighbor.node] = dist[curNode] + neighbor.cost;
                    pq.offer(new Node(neighbor.node, dist[neighbor.node]));
                }
            }
        }

        return dist;
    }
}
