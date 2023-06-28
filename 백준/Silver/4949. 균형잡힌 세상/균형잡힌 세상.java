import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String line;
        while ((line = br.readLine()) != null){
            if(line.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            boolean chk = false;
            for(char c : line.toCharArray()){
                if(c == '(' || c == '[') stack.add(c);
                if((c == ')' || c == ']') && stack.isEmpty()) {
                    sb.append("no\n");
                    chk = true;
                    break;
                }
                if(c == ')' && stack.peek() != '(') {
                    sb.append("no\n");
                    chk = true;
                    break;
                }
                if(c == ']' && stack.peek() != '[') {
                    sb.append("no\n");
                    chk = true;
                    break;
                }
                if((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[')){
                    stack.pop();
                }
            }
            if(!chk){
                if(stack.isEmpty()) sb.append("yes\n");
                else sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}
