import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int K;
    private static int time = 0;
    private static int method = 0;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            bw.write(0 + "\n" + 1);
        }

        else {
            bfs();
            bw.write(time + "\n" + method);
        }

        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        boolean[] isVisit = new boolean[100001];
        isVisit[N] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                isVisit[cur] = true;

                for (int j = -1; j <= 1; j++) {
                    int next = j == 0 ? cur * 2 : cur + j;

                    if (next < 0 || next > 100000 || isVisit[next])
                        continue;

                    if (next == K)
                        method++;
                    else {
                        q.offer(next);
                    }
                }
            }

            time++;
            if (method > 0)
                return;
        }
    }

}
