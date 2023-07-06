import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static boolean[] bl = new boolean[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N == K) {
            System.out.println(0);
            return;
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        bfs(que, 0, K);

    }

    private static void bfs(Queue<Integer> que, int time, int K) {
        while(!que.isEmpty()) {
            int size = que.size();
            time++;

            for(int i = 0; i < size; i++) {
                int now = que.poll();
                bl[now] = true;

                if(now + 1 == K || now - 1 == K || now * 2 == K) {
                    System.out.println(time);
                    return;
                }
                if(now + 1 <= 100000 && !bl[now + 1]) {
                    que.add(now + 1);
                    bl[now + 1] = true;
                }
                if(now - 1 >= 0  && !bl[now - 1]) {
                    que.add(now - 1);
                    bl[now - 1] = true;
                }
                if(now * 2 <= 100000  && !bl[now * 2]) {
                    que.add(now * 2);
                    bl[now * 2] = true;
                }
            }
        }
        System.out.println(time);
    }

}
