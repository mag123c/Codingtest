import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static class Stack {
        ArrayList<Integer> stack;

        Stack() {
            this.stack = new ArrayList<>();
        }

        void push(int param) {
            this.stack.add(param);
        }

        void pop() {
            if (stack.isEmpty()) print(-1);
            else {
                print(stack.get(stack.size() - 1));
                stack.remove(stack.size() - 1);
            }
        }

        void size() {
            print(stack.size());
        }

        void checkIsEmpty() {
            if (stack.isEmpty()) print(1);
            else print(0);
        }

        void peek() {
            if (stack.isEmpty()) print(-1);
            else print(stack.get(stack.size() - 1));
        }
        
        void print(int number) {
            try {
                bw.write(String.valueOf(number) + "\n");
            }
            catch (IOException e) {
                
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack stack = new Stack();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());

            switch (number) {
                case 1:
                    number = Integer.parseInt(st.nextToken());
                    stack.push(number);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.size();
                    break;
                case 4:
                    stack.checkIsEmpty();
                    break;
                case 5:
                    stack.peek();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}