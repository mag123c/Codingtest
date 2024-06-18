import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int len = word.length();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < len; i ++) {
            char cur = word.charAt(i);

            if (cur == '(') {
                stack.push(cur);
            }
            else if (cur == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    bw.write(stack.pop());
                }
                stack.pop();
            }
            else if (isOperator(cur)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(cur)) {
                    bw.write(stack.pop());
                }
                stack.push(cur);
            }
            else bw.write(cur);
        }

        while(!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        bw.flush();
        bw.close();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char op) {
        switch (op) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '(':
                return 0;
        }
        return -1;
    }
}
