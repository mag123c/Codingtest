import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                else return Math.abs(o1) - Math.abs(o2);
            }
        });
        for (int i = 0; i < N; i ++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                int out = queue.isEmpty() ? 0 : queue.poll();
                System.out.println(out);
            }
            else queue.offer(x);
        }

    }
}
