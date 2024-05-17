import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] isVisit = new boolean[N + 1];
        int[] output = new int[M];

        backtracking(N, M, 0, isVisit, output);

        bw.flush();
        bw.close();
    }

    private static void backtracking(int N, int M, int depth, boolean[] isVisit, int[] output) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                print(output[i] + " ");
            }
            print("\n");
            return;
        }

        for (int i = 1; i <= N; i ++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                output[depth] = i;
                backtracking(N, M, depth + 1, isVisit, output);
                isVisit[i] = false;
            }
        }
    }

    private static void print(String value) throws IOException {
        bw.write(value);
    }
}
