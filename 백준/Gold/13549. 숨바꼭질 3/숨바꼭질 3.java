import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        Deque<Integer> q = new LinkedList<>();
        q.offer(N);
        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) return dist[cur];

            if (cur * 2 <= 100000 && dist[cur * 2] > dist[cur]) {
                q.offerFirst(cur * 2);
                dist[cur * 2] = dist[cur];
            }


            if (cur + 1 <= 100000 && dist[cur + 1] > dist[cur] + 1) {
                q.offerLast(cur + 1);
                dist[cur + 1] = dist[cur] + 1;
            }

            if (cur - 1 >= 0 && dist[cur - 1] > dist[cur] + 1) {
                q.offerLast(cur - 1);
                dist[cur - 1] = dist[cur] + 1;
            }
        }

        return -1;
    }

}
