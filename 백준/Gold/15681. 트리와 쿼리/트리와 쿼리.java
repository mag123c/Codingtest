import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<List<Integer>> tree = new ArrayList<>();
        int[] parent = new int[N + 1];
        int[] subTree = new int[N + 1];

        for (int i = 0; i <= N; i ++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i ++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            tree.get(U).add(V);
            tree.get(V).add(U);
        }

        buildTree(tree, parent, R, -1);

        calSubTree(tree, parent, subTree, R);

        for (int i = 0; i < Q; i ++) {
            int node = Integer.parseInt(br.readLine());
            bw.write(subTree[node] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void buildTree(List<List<Integer>> tree, int[] parent, int cur, int x) {
        parent[cur] = x;
        for (int next: tree.get(cur)) {
            if (next != x) {
                buildTree(tree, parent, next, cur);
            }
        }
    }

    private static void calSubTree(List<List<Integer>> tree, int[] parent, int[] subTree, int cur) {
        subTree[cur] = 1;
        for (int next: tree.get(cur)) {
            if (next != parent[cur]) {
                calSubTree(tree, parent, subTree, next);
                subTree[cur] += subTree[next];
            }
        }
    }
}
