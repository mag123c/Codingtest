import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        double answer = 0;
        for (int i = 0; i < N; i ++) {
            long x1 = arr[i][0];
            long y1 = arr[i][1];
            long x2 = arr[(i + 1) % N][0];
            long y2 = arr[(i + 1) % N][1];
            answer += (x1 * y2) - (y1 * x2);
        }

        answer = Math.abs(answer) / 2.0;
        System.out.printf("%.1f", answer);
    }
}
