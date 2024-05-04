import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int order = 1;
        for (int i = 0; i < N; i++) {
            int ticket = arr[i];

            if (ticket != order) {
                if (!stack.isEmpty() && stack.peek() == order) {
                    stack.pop();
                    i--;
                    order++;
                }
                else {
                    stack.push(ticket);
                }
            }
            else order++;
        }

        boolean tf = true;

        for (int i = 0; i < stack.size(); i ++) {
            int num = stack.pop();

            if (num == order) order++;

            else {
                tf = false;
                break;
            }
        }

        if (tf) bw.write("Nice");
        else bw.write("Sad");

        bw.flush();
        bw.close();
    }
}