import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] offCount = new int[N];
        String[] line = new String[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int zero = 0;
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '0') {
                    zero++;
                }
            }
            offCount[i] = zero;
            line[i] = s;
        }

        int K = Integer.parseInt(br.readLine());
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (offCount[i] <= K && (K - offCount[i]) % 2 == 0) {
                int equalCount = 1;
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    if (line[i].equals(line[j])) {
                        equalCount++;
                    }
                }
                max = Math.max(max, equalCount);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
