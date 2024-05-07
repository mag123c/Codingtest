import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int isStack = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st2.nextToken());

            if (isStack == 0) {
                deque.offer(number);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            int targetNum = Integer.parseInt(st.nextToken());
            deque.offerFirst(targetNum);
            print(deque.pollLast(), bw);
        }





        bw.flush();
        bw.close();
    }

    public static void print(int number, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(number) + " ");
    }


}