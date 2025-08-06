import java.io.*;
import java.util.*;

public class Main {
    static class Problem {
        int deadline;
        int cupNoodle;

        public Problem(int deadline, int cupNoodle) {
            this.deadline = deadline;
            this.cupNoodle = cupNoodle;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Problem> list = new ArrayList<>();
        for (int i = 0; i < N; i ++) {
            String[] line = br.readLine().split(" ");
            list.add(new Problem(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        list.sort(Comparator.comparingInt(p -> p.deadline));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Problem p: list) {
            pq.offer(p.cupNoodle);
            if (pq.size() > p.deadline) {
                pq.poll();
            }
        }

        int answer = 0;
        for (int i: pq) {
            answer += i;
        }
        System.out.println(answer);
    }

}
