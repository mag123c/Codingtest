import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int node;
        int cost;

        public Node (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private static ArrayList<ArrayList<Node>> nodeList = new ArrayList<>();
    private static boolean[] isVisit;

    private static int fartestNode;
    private static int maxLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i ++) {
            nodeList.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList.get(parent).add(new Node(child, weight));
            nodeList.get(child).add(new Node(parent, weight));
        }

        maxLength = 0;
        isVisit = new boolean[N + 1];
        dfs(1, 0);

        maxLength = 0;
        isVisit = new boolean[N + 1];
        dfs(fartestNode, 0);

        System.out.println(maxLength);
    }

    private static void dfs(int current, int dist) {
        isVisit[current] = true;

        if (dist > maxLength) {
            maxLength = dist;
            fartestNode = current;
        }

        for (Node node: nodeList.get(current)) {
            if (!isVisit[node.node]) {
                dfs(node.node, dist + node.cost);
            }
        }
    }

}
