import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[N][5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < 5; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean[] isVisit = new boolean[N + 1];

        for (int i = 1; i < 5; i ++) {
            int idx = i;
            Arrays.sort(score, (o1, o2) -> {
                if (o1[idx] == o2[idx]) {
                    return o1[0] - o2[0];
                }
                return o2[idx] - o1[idx];
            });

            for (int j = 0; j < N; j ++) {
                int current = score[j][0];
                if (!isVisit[current]) {
                    isVisit[current] = true;
                    sb.append(current).append(" ");
                    break;
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}
