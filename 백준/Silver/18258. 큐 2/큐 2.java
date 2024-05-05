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
            switch (keyword) {
                case "push":
                    int number = Integer.parseInt(st.nextToken());
                    queue.offer(number);
                    break;
                case "pop":
                    if (isEmpty(queue)) print(-1, bw);
                    else print(queue.pop(), bw);
                    break;
                case "size":
                    print(queue.size(), bw);
                    break;
                case "empty":
                    if (isEmpty(queue)) print(1, bw);
                    else print(0, bw);
                    break;
                case "front":
                    if (isEmpty(queue)) print(-1, bw);
                    else print(queue.getFirst(), bw);
                    break;
                case "back":
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