import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i ++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            degree[B]++;
            graph.get(A).add(B);
        }

        topologySort(N, degree, graph);
        System.out.println(sb);
    }

    private static void topologySort(int N, int[] degree, List<List<Integer>> graph) {
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 1; i <= N; i ++) {
            if (degree[i] == 0) que.offer(i);
        }

        while(!que.isEmpty()) {
            int V = que.poll();
            sb.append(V).append(" ");

            for (int next: graph.get(V)) {
                if (--degree[next] == 0) {
                    que.offer(next);
                }
            }
        }
    }
}
