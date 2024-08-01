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

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> lis = new ArrayList<>();
        int[] degree = new int [N + 1];

        for (int i = 0; i <= N; i ++) {
            lis.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int[] arr = new int[number];
            for (int j = 0; j < number; j ++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            for (int j = 0; j < number - 1; j ++) {
                lis.get(arr[j]).add(arr[j + 1]);
                degree[arr[j + 1]]++;
            }
        }

        topologySort(N, degree, lis);
    }

    private static void topologySort(int N, int[] degree,List<List<Integer>> lis) {
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i ++) {
            if (degree[i] == 0) que.offer(i);
        }

        while (!que.isEmpty()) {
            int curr = que.poll();
            cnt++;
            sb.append(curr).append("\n");

            for (int next: lis.get(curr)) {
                if (degree[next] == 0) continue;
                if (--degree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        if (cnt < N) System.out.println(0);
        else System.out.println(sb);
    }
}
