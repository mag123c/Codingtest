import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private static List<List<Node>> tree;
    private static int V;
    private static boolean[] isVisit;
    private static int maxDistance;
    private static int farthestNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        StringTokenizer st;

        tree = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                tree.get(start).add(new Node(node, cost));
            }
        }

        isVisit = new boolean[V + 1];
        maxDistance = 0;
        dfs(1, 0);

        isVisit = new boolean[V + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    private static void dfs(int current, int dist) {
        isVisit[current] = true;

        if (dist > maxDistance) {
            maxDistance = dist;
            farthestNode = current;
        }

        for (Node node : tree.get(current)) {
            if (!isVisit[node.dest]) {
                dfs(node.dest, dist + node.cost);
            }
        }
    }
}
