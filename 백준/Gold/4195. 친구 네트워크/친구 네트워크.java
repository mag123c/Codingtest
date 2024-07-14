import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            int cnt = 0;
            int[] parent = new int[200001];
            int[] size = new int[200001];

            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, cnt);
                    parent[cnt] = cnt;
                    size[cnt] = 1;
                    cnt++;
                }

                if (!map.containsKey(b)) {
                    map.put(b, cnt);
                    parent[cnt] = cnt;
                    size[cnt] = 1;
                    cnt++;
                }

                union(map.get(a), map.get(b), parent, size);
                int root = find(parent, map.get(a));
                bw.write(size[root] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b, int[] parent, int[] size) {
        a = find(parent, a);
        b = find(parent, b);

        if (a != b) {
            if (size[a] < size[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            size[a] += size[b];
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
