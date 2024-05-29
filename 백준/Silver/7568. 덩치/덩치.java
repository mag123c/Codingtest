import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] wh = new int[N][2];
        int[] rank = new int[N];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());

            wh[i][0] = Integer.parseInt(st.nextToken());
            wh[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (i != j && wh[i][0] < wh[j][0] && wh[i][1] < wh[j][1]) {
                    rank[i]++;
                }
            }
        }

        for (int i : rank) {
            bw.write(i + 1 + " ");
        }

        bw.flush();
        bw.close();
    }
}