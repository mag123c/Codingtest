import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findBiggestWindow(arr);
    }

    private static void findBiggestWindow(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            arr[i] = Math.max(arr[i - 1] + arr[i], arr[i]);
        }

        Arrays.sort(arr);

        System.out.println(arr[arr.length - 1]);
    }
}