import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i ++) {
            deque.offer(i);
        }
        st = new StringTokenizer(br.readLine());

        int total = 0;
        for (int i = 0; i < M; i ++) {
            int target = Integer.parseInt(st.nextToken());
            total += calculateMinimumMoves(deque, target);
        }

        System.out.println(total);
    }

    private static int calculateMinimumMoves(Deque<Integer> deque, int target) {
        int moves = 0;

        while (true) {
            int current = deque.peekFirst();
            if (current == target) {
                deque.pollFirst();
                return moves;
            } else {
                int index = 0;
                for (Integer num : deque) {
                    if (num == target) break;
                    index++;
                }

                if (index <= deque.size() / 2) {
                    deque.offerLast(deque.pollFirst());
                } else {
                    deque.offerFirst(deque.pollLast());
                }
                moves++;
            }
        }
    }

}
