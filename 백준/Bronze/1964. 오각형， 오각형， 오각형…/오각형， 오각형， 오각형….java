import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        arr[1] = 5;

        for (int i = 2; i <= N; i ++) {
            arr[i] = (arr[i - 1] + (3 * i) + 1) % 45678;
        }

        System.out.println(arr[N]);
    }
}
