import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int T;
    private static int[] items;
    private static int maxItems = 0;

    public static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }

    private static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        items = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int tree = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(tree).add(new Node(node, weight));
            graph.get(node).add(new Node(tree, weight));
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        System.out.println(maxItems);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int curNode = currentNode.node;

            for (Node node : graph.get(curNode)) {
                int newDist = dist[curNode] + node.weight;

                if (dist[node.node] > newDist) {
                    dist[node.node] = newDist;
                    pq.offer(new Node(node.node, newDist));
                }
            }
        }
        maxItems = Math.max(maxItems, getItems(dist));
    }

    private static int getItems(int[] dist) {
        int itemCnt = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) {
                itemCnt += items[i];
            }
        }
        return itemCnt;
    }
}
