import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] ladder = new int[101];
    private static int[] snake = new int[101];
    private static boolean[] bl = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            if(i < N) ladder[before] = after;
            else snake[before] = after;
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        int cnt = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            cnt++;

            for(int i = 0; i < size; i++) {
                int now = que.poll();
                for(int j = 1; j <= 6; j++) {
                    int current = now + j;
                    if(current > 100) continue;
                    if(ladder[current] > 0) {
                        current = ladder[current];
                    }
                    else if(snake[current] > 0) {
                        current = snake[current];
                    }
                    if(bl[current]) continue;

                    if(current == 100) {
                        System.out.println(cnt);
                        return;
                    }
                    bl[current] = true;
                    que.add(current);
                }
            }
        }
    }
}