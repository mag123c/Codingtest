import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node> {
        int node;
        int cost;
        public Node (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<List<Node>> nodeList = new ArrayList<>();
        for (int i = 0; i <= V; i ++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i ++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodeList.get(u).add(new Node(v, w));
        }

        int[] dist = dijkstra(K, V, nodeList);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= V; i ++) {
            if (i == K) bw.write("0\n");
            else if (dist[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int[] dijkstra(int K, int V, List<List<Node>> nodeList) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] isVisit = new boolean[V + 1];
        int[] dist = new int[V + 1];

        q.offer(new Node(K, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();
            int curNode = current.node;

            if (!isVisit[curNode]) {
                isVisit[curNode] = true;

                for (Node n : nodeList.get(curNode)) {
                    if (dist[n.node] > dist[curNode] + n.cost) {
                        dist[n.node] = dist[curNode] + n.cost;
                        q.offer(new Node(n.node, dist[n.node]));
                    }
                }
            }
        }

        return dist;
    }
}