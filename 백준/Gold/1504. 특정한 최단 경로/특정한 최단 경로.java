import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int E;
    private static int v1;
    private static int v2;
    private static int[] dist;
    private static boolean[] visited;
    private static List<List<Node>> nodeList = new ArrayList<>();
    private static int INF = 200000000;

    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i ++) {
            nodeList.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList.get(before).add(new Node(after, weight));
            nodeList.get(after).add(new Node(before, weight));
        }

        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        int distV1 = 0;
        distV1 += dist(1, v1);
        distV1 += dist(v1, v2);
        distV1 += dist(v2, N);

        int distV2 = 0;
        distV2 += dist(1, v2);
        distV2 += dist(v2, v1);
        distV2 += dist(v1, N);

        System.out.println(distV1 >= INF && distV2 >= INF ? -1 : Math.min(distV1, distV2));
    }

    private static int dist(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[start] = 0;

        PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
        nodeQueue.offer(new Node(start, 0));

        while (!nodeQueue.isEmpty()) {
            Node curNode = nodeQueue.poll();
            int cur = curNode.node;

            if(!visited[cur]) {
                visited[cur] = true;

                for(Node node : nodeList.get(cur)) {
                    if(!visited[node.node] && dist[node.node] > dist[cur] + node.cost) {
                        dist[node.node] = dist[cur] + node.cost;
                        nodeQueue.offer(new Node(node.node, dist[node.node]));
                    }
                }
            }
        }
        return dist[end];
    }
}