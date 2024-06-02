import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer(arr, N, S);
    }

    private static void twoPointer(int[] arr, int N, int S) {
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;

        while(right < N) {
            sum += arr[right];

            while (sum >= S) {
                len = Math.min(len, right - left + 1);
                sum -= arr[left];
                left++;
            }

            if (len == 1) break;

            right++;
        }

        System.out.println(len == Integer.MAX_VALUE ? "0" : len);
    }

}