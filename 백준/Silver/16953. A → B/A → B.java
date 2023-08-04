import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] chk;
    static int cnt = 0;
    static LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        find();

        System.out.println(cnt);

    }

    private static void find() {
        Queue<Long> queue = new LinkedList<>();
        queue.offer((long) N);
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            for(int i = 0 ; i < size; i ++) {
                long current = queue.poll();
                if(current == M) return;

                long plus = (current * 10) + 1;
                long mul = current * 2;

                if(plus <= M) queue.offer(plus);
                if(mul <= M) queue.offer(mul);
            }
        }
        cnt = -1;
    }
}
