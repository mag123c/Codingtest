import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int window = 0;
        for (int i = 0; i < K; i ++) {
            window += arr[i];
        }

        int max = window;

        for (int i = K; i < N; i ++) {
            window = window - arr[i - K] + arr[i];
            max = Math.max(max, window);
        }

        System.out.println(max);

    }

}


