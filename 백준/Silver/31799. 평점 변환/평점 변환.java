import java.io.*;
import java.util.Stack;

public class Main {

    private static Stack<String> stack = new Stack<>();
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int len = word.length();

        for (int i = 0; i < len; i++) {
            if (i < len - 1 && isAlphabet(word.charAt(i)) && !isAlphabet(word.charAt(i + 1))) {
                check(word.charAt(i) + String.valueOf(word.charAt(i + 1)));
                i++;
            } else {
                check(String.valueOf(word.charAt(i)));
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean isAlphabet(char c) {
        return c == 'A' || c == 'B' || c == 'C';
    }

    private static void check(String s) throws IOException {
        if (s.contains("0")) {
            s = s.substring(0, 1);
        }
        if (s.contains("C")) {
            bw.write("B");
        } else if (s.equals("B-") || s.equals("B")) {
            if (stack.isEmpty() || stack.peek().contains("C")) {
                bw.write("D");
            } else {
                bw.write("B");
            }
        } else if (s.equals("A-") || s.equals("B+")) {
            if (stack.isEmpty() || stack.peek().contains("C") || stack.peek().equals("B") || stack.peek().equals("B-")) {
                bw.write("P");
            } else {
                bw.write("D");
            }
        } else if (s.equals("A")) {
            if (stack.isEmpty() || stack.peek().contains("B") || stack.peek().contains("C") || stack.peek().equals("A-")) {
                bw.write("E");
            } else {
                bw.write("P");
            }
        } else if (s.equals("A+")) {
            bw.write("E");
        } else {
            bw.write("E");
        }

        stack.push(s);
    }
}
