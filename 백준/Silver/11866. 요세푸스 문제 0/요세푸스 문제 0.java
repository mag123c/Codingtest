import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i ++) {
            queue.add(i);
        }

        StringBuffer sb = new StringBuffer();

        while(!queue.isEmpty()) {
            for(int i = 1; i < K; i ++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }

        System.out.println("<" + (sb.toString()).substring(0, sb.length() -2) + ">");

    }
}
