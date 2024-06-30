import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] speed = new int[N];
        
        for (int i = 0; i < N; i++) {
            speed[i] = Integer.parseInt(st.nextToken());
        }

        long cur = 0;
        long maxSum = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (cur + 1 > speed[i]) {
                cur = speed[i];
            } else {
                cur++;
            }
            maxSum += cur;
        }

        System.out.println(maxSum);
    }
}
