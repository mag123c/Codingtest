import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N + 1];
        arr[0] = 0;
        arr[1] = 1;

        dp(N, arr);
        System.out.println(arr[N]);
    }

    private static void dp(int N, long[] arr) {
        if (N >= 2) arr[2] = 3;

        for (int i = 3; i <= N; i ++) {
            arr[i] = (2 * (arr[i - 2]) + arr[i - 1]) % 10007;
        }
    }

}