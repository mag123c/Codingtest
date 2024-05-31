import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(binarySearch(arr, N, C));

    }

    private static int binarySearch(int[] arr, int N, int C) {
        int left = 1;
        int right = arr[arr.length - 1] - arr[0];
        int available = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canRouters(arr, N, C, mid)) {
                available = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return available;
    }

    private static boolean canRouters(int[] arr, int N, int C, int mid) {
        int cnt = 1;
        int start = arr[0];

        for (int i = 1; i < N; i ++) {
            if (arr[i] - start >= mid) {
                start = arr[i];
                cnt++;
            }
            if (cnt == C) return true;
        }
        return false;
    }

}