import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i ++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                stack.pop();
            }
            else stack.add(number);
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
    }
}