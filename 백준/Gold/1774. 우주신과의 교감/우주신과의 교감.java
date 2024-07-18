import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static class Node {

        int node1;
        int node2;
        double cost;

        public Node(int n1, int n2, double c) {
            this.node1 = n1;
            this.node2 = n2;
            this.cost = c;
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, int[]> map = new HashMap<>();


        for (int i = 1; i <= N; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(i, new int[] {a, b});
        }

        int[] parent = new int[N + 1];

        for (int i = 1; i <= N; i ++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(parent, a, b);
        }

        List<Node> lis = makeGraph(parent, N, map);
        double mst = 0;

        for (Node n: lis) {
            int n1 = n.node1;
            int n2 = n.node2;

            if (find(parent, n1) != find(parent, n2)) {
                union(parent, n1, n2);
                mst += n.cost;
            }
        }

        System.out.printf("%.2f\n", mst);

    }

    private static List<Node> makeGraph(int[] parent, int N, HashMap<Integer, int[]> map) {
        List<Node> lis = new ArrayList<>();

        for (int i = 1; i <= N; i ++) {
            for (int j = 1; j <= N; j ++) {
                if (find(parent, i) != find(parent, j)) {
                    double cost = calCost(map, i, j);
                    lis.add(new Node(i, j, cost));
                }
            }
        }

        Collections.sort(lis, (o1, o2) -> Double.compare(o1.cost, o2.cost));

        return lis;
    }

    private static double calCost(HashMap<Integer, int[]> map, int x, int y) {
        int[] xLocation = map.get(x);
        int[] yLocation = map.get(y);

        return Math.sqrt(Math.pow(xLocation[0] - yLocation[0], 2) + Math.pow(xLocation[1] - yLocation[1], 2));
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a == b) return;
        if (a < b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }
}
