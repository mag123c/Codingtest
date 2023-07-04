import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            String[] tmp = new String[10000];
            boolean[] bl = new boolean[10000];
            Queue<Integer> queue = new LinkedList<>();

            Arrays.fill(tmp, "");
            queue.add(before);
            bl[before] = true;

            System.out.println(bfs(queue, tmp, after, bl));
        }

    }

    private static String bfs(Queue<Integer> queue, String[] tmp, int after, boolean[] bl) {
        while(!queue.isEmpty()) {
            int number = queue.poll();

            if(number == after) return tmp[number];

            int d = (number * 2) % 10000;
            int s = number == 0 ? 9999 : number - 1;
            int l = (number % 1000) * 10 + (number / 1000);
            int r = (number % 10) * 1000 + (number / 10);

            if(!bl[d]) {
                tmp[d] = tmp[number] + "D";
                queue.add(d);
                bl[d] = true;
            }
            if(!bl[s]) {
                tmp[s] = tmp[number] + "S";
                queue.add(s);
                bl[s] = true;
            }
            if(!bl[l]) {
                tmp[l] = tmp[number] + "L";
                queue.add(l);
                bl[l] = true;
            }
            if(!bl[r]) {
                tmp[r] = tmp[number] + "R";
                queue.add(r);
                bl[r] = true;
            }

        }
        return "";
    }
}
