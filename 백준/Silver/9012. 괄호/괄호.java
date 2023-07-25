import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < N; i ++) {
            Stack<Character> stack = new Stack<>();

            String current = br.readLine();
            int length = current.length();

            for(int j = 0; j < length; j ++) {
                char tmp = current.charAt(j);
                if(stack.isEmpty()) stack.add(tmp);
                else if(stack.peek() == '(' && tmp == ')') {
                    stack.pop();
                }
                else {
                    stack.add(tmp);
                }
            }

            if(stack.size() == 0) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
