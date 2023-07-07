import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i ++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) outAndDel();
            else input(x);
        }
    }

    private static void outAndDel() {
        if(priorityQueue.isEmpty()) System.out.println(0);
        else System.out.println(priorityQueue.poll());

    }

    private static void input(int x) {
        priorityQueue.offer(x);
    }
}