import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    private static int[] chk;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        chk = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i ++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            arr.get(before).add(after);
            arr.get(after).add(before);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int now = queue.poll();

                for(int j : arr.get(now)) {
                    if(!visited[j]) {
                        queue.offer(j);
                        chk[j] = now;
                        visited[j] = true;                        
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 2; i <= N; i ++) {
            sb.append(chk[i] + "\n");
        }
        System.out.println(sb);
    }
}
