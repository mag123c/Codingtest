import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int start;
    private static int end;
    private static int[] dist;
    private static boolean[] visited;
    private static List<List<Node>> nodeList = new ArrayList<>();

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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i <= N; i ++) {
            nodeList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList.get(before).add(new Node(after, weight));
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        visited = new boolean[N + 1];

        System.out.println(dist());
    }

    private static int dist() {
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