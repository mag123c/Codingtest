import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] costs = new int[N + 1];
            int[] degree = new int[N + 1];
            int[] dp = new int[N + 1];            

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j ++) {
                costs[j] = Integer.parseInt(st.nextToken());
                dp[j] = costs[j];
            }

            List<List<Integer>> lis = new ArrayList<>();
            for (int j = 0; j <= N; j ++) {
                lis.add(new ArrayList<>());
            }
            for (int j = 0; j < K; j ++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                degree[to]++;
                lis.get(from).add(to);
            }

            int W = Integer.parseInt(br.readLine());

            bw.write(topologySort(lis, costs, degree, dp, N, W) + "\n");

        }


        bw.flush();
        bw.close();
    }

    private static int topologySort(List<List<Integer>> lis, int[] costs, int[] degree, int[] dp, int N, int W) {
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 1; i <= N; i ++) {
            if (degree[i] == 0) que.offer(i);
        }

        while(!que.isEmpty()) {
            int current = que.poll();

            for (int next: lis.get(current)) {
                dp[next] = Math.max(dp[next], dp[current] + costs[next]);
                if (--degree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        return dp[W];
    }

}
