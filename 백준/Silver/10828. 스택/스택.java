import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> stack = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()){
                case "push": push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" : pop();
                    break;
                case "size" : size();
                    break;
                case "empty" : empty();
                    break;
                case "top" : top();
                    break;

            }

        }
    }
    private static void push(int i) {
        stack.add(i);
    }

    private static void pop() {
        if(stack.isEmpty()) System.out.println(-1);
        else{
            System.out.println(stack.get(stack.size() - 1));
            stack.remove(stack.size() - 1);
        }
    }

    private static void size() {
        System.out.println(stack.size());
    }

    private static void empty() {
        if(stack.isEmpty()) System.out.println(1);
        else System.out.println(0);
    }
    private static void top() {
        if(stack.isEmpty()) System.out.println(-1);
        else System.out.println(stack.get(stack.size() - 1));
    }

}
