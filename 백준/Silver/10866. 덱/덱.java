import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> deque = new ArrayList<>();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    pop_front();
                    break;
                case "pop_back":
                    pop_back();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    private static void push_front(int s) {
        List<Integer> clone = new ArrayList<>();
        clone.add(s);
        for(int i : deque) clone.add(i);
        deque = clone;
    }
    private static void push_back(int s) {
        deque.add(s);
    }
    private static void pop_front() {
        if(deque.isEmpty()) sb.append(-1 + "\n");
        else {
            sb.append(deque.remove(0) + "\n");
        }
    }

    private static void pop_back() {
        if(deque.isEmpty()) sb.append(-1 + "\n");
        else {
            sb.append(deque.remove(deque.size() - 1) + "\n");
        }
    }

    private static void size() {
        sb.append(deque.size() + "\n");
    }

    private static void empty() {
        if(deque.isEmpty()) sb.append(1 + "\n");
        else sb.append(0 + "\n");
    }

    private static void front() {
        if(deque.isEmpty()) sb.append(-1 + "\n");
        else {
            sb.append(deque.get(0) + "\n");
        }
    }

    private static void back() {
        if(deque.isEmpty()) sb.append(-1 + "\n");
        else {
            sb.append(deque.get(deque.size() - 1) + "\n");
        }
    }

}
