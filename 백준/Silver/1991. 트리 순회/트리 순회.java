import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        String value;
        Node lt, rt;
        public Node (String value) {
            this.value = value;
            lt=rt=null;
        }
    }

    private static Map<String, Node> nodes = new HashMap<>();
    private static Node root;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String parent = null;
        String left = null;
        String right = null;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            parent = st.nextToken();
            left = st.nextToken();
            right = st.nextToken();
            Node parentNode = nodes.computeIfAbsent(parent, Node::new);

            if (root == null) root = parentNode;

            if (!left.equals(".")) {
                parentNode.lt = nodes.computeIfAbsent(left, Node::new);
            }

            if (!right.equals(".")) {
                parentNode.rt = nodes.computeIfAbsent(right, Node::new);
            }
        }

        traversal();
        bw.flush();
        bw.close();
        br.close();
    }

    private static void traversal() throws IOException {
        preorder(root);
        bw.newLine();
        inOrder(root);
        bw.newLine();
        postOrder(root);
        bw.newLine();
    }

    private static void preorder(Node node) throws IOException {
        if (node == null) return;

        bw.write(node.value);
        if (node.lt != null) preorder(node.lt);
        if (node.rt != null) preorder(node.rt);
    }

    private static void inOrder(Node node) throws IOException  {
        if (node == null) return;

        if (node.lt != null) inOrder(node.lt);
        bw.write(node.value);
        if (node.rt != null) inOrder(node.rt);
    }

    private static void postOrder(Node node) throws IOException  {
        if (node == null) return;

        if (node.lt != null) postOrder(node.lt);
        if (node.rt != null) postOrder(node.rt);
        bw.write(node.value);
    }
}
