import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] before = new int[N];
        Deque<Integer> after = new ArrayDeque<>();
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) {
                if (i == 0) {
                    before[j] = Integer.parseInt(st.nextToken());
                } else {
                    after.add(Integer.parseInt(st.nextToken()));
                }
            }            
        }

        for (int i = 0; i < N; i ++) {
            if (after.peekFirst() == before[0] && after.peekLast() == before[N - 1]) {
                System.out.println(puzzling(N, before, after));
                return;
            }
            else if (after.peekFirst() == before[N - 1] && after.peekLast() == before[0]) {
                System.out.println(reversePuzzling(N, before, after));
                return;
            }
            else {
                after.addFirst(after.pollLast());
            }
        }

        System.out.println("bad puzzle");
    }

    private static String puzzling(int N, int[] before, Deque<Integer> after) {
        for (int i = 0; i < N; i ++) {
            if (after.poll() != before[i]) {
                return "bad puzzle";
            }
        }
        return "good puzzle";
    }

    private static String reversePuzzling(int N, int[] before, Deque<Integer> after) {
        for (int i = N - 1; i >= 0; i --) {
            if (after.poll() != before[i]) {
                return "bad puzzle";
            }
        }
        return "good puzzle";
    }
}
