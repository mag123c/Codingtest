import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Node implements Comparable<Node>{
        int node;
        int weight;

        public Node (int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }

    private static int N;
    private static int M;
    private static int[] dist;
    private static int[] prev;
    private static List<List<Node>> graph = new ArrayList<>();
    private static int start;
    private static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        prev = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        for (int i = 0; i <= N; i ++) {
            graph.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int tree = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(tree).add(new Node(node, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

         List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = path.size();
        bw.write(dist[end] + "\n");
        bw.write(size + "\n");

        for (int node: path) {
            bw.write(node + " ");
        }

        bw.flush();
        bw.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        List<Integer> path = new ArrayList<>();

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.node;

            if (current == end) break;

            for (Node node: graph.get(currentNode.node)) {
                int newDist = dist[current] + node.weight;
                if (dist[node.node] > newDist) {
                    dist[node.node] = newDist;
                    prev[node.node] = current;
                    pq.offer(new Node(node.node, newDist));
                }
            }
        }

    }
}
