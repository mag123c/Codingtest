import java.io.*;

public class Main {

    public static class Node {
        int node;
        Node lt, rt;

        public Node (int node) {
            this.node = node;
            lt=rt=null;
        }
    }

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rootValue = Integer.parseInt(br.readLine());
        Node root = new Node(rootValue);

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int cur = Integer.parseInt(line);
            insert(root, cur);
        }

        postOrder(root);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void postOrder(Node root) throws IOException {
        if (root == null) return;
        postOrder(root.lt);
        postOrder(root.rt);
        bw.write(root.node + "\n");
    }

    public static void insert(Node root, int value) {
        if (value < root.node) {
            if (root.lt == null) {
                root.lt = new Node(value);
            }
            else {
                insert(root.lt, value);
            }
        }
        else {
            if (root.rt == null) {
                root.rt = new Node(value);
            }
            else {
                insert(root.rt, value);
            }
        }
    }
}
