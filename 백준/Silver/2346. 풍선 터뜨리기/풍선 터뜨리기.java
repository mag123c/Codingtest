import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            deque.offer(i);
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //음수일경우 offerFirst(pollLast)
        //양수일경우 offer(poll)
        int idx;
        int targetNum = 0;
        while(!deque.isEmpty()) {
            idx = targetNum < 0 ? deque.pollLast() : deque.poll();
            targetNum = arr[idx];

            if (deque.size() == 0) {
                print(idx + 1, bw);
                break;
            }

            if (targetNum < 0) {
                int index = Math.abs(targetNum);
                for (int i = 0; i < index - 1; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
            else {
                for(int i = 0; i < targetNum - 1; i++) {
                    deque.offer(deque.poll());
                }
            }

            print(idx + 1, bw);
        }

        bw.flush();
        bw.close();
    }

    public static void print(int number, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(number) + " ");
    }


}