import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] init = new int[N];
            for (int j = 0; j < N; j++) {
                init[j] = Integer.parseInt(st.nextToken());
                if (init[j] % 2 == 1) {
                    init[j]++;
                }
            }

            int cycle = fairCandies(N, init);
            bw.write(cycle + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int fairCandies(int N, int[] init) {
        int cycle = 0;

        while (true) {
            boolean allEqual = true;
            for (int i = 1; i < N; i++) {
                if (init[i] != init[0]) {
                    allEqual = false;
                    break;
                }
            }

            if (allEqual) {
                return cycle;
            }

            int[] newCandies = new int[N];
            for (int i = 0; i < N; i++) {
                newCandies[(i + 1) % N] += init[i] / 2;
                newCandies[i] += init[i] - (init[i] / 2);
            }

            for (int i = 0; i < N; i++) {
                if (newCandies[i] % 2 == 1) {
                    newCandies[i]++;
                }
            }

            init = newCandies;
            cycle++;
        }
    }
}
