import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine(), " ");

            String keyword = st.nextToken();
            int number;
            switch (keyword) {
                case "1":
                    number = Integer.parseInt(st.nextToken());
                    queue.offerFirst(number);
                    break;
                case "2":
                    number = Integer.parseInt(st.nextToken());
                    queue.offerLast(number);
                    break;
                case "3":
                    if (isEmpty(queue)) print(-1, bw);
                    else print(queue.poll(), bw);
                    break;
                case "4":
                    if (isEmpty(queue)) print(-1, bw);
                    else print(queue.pollLast(), bw);
                    break;
                case "5":
                    print(queue.size(), bw);
                    break;
                case "6":
                    if (isEmpty(queue)) print(1, bw);
                    else print(0, bw);
                    break;
                case "7":
                    if (isEmpty(queue)) print(-1, bw);
                    else print(queue.getFirst(), bw);
                    break;
                case "8":
                    if (isEmpty(queue)) print(-1, bw);
                    else print(queue.getLast(), bw);
                    break;


            }
        }

        bw.flush();
        bw.close();
    }

    public static void print(int number, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(number) + "\n");
    }

    public static boolean isEmpty(Deque queue) {
        return queue.isEmpty();
    }
}