import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int[] liquid = twoPointer(N, arr);

        System.out.println(liquid[0] + " " + liquid[1]);
    }

    private static int[] twoPointer(int N, int[] arr) {
        int min = Integer.MAX_VALUE;

        int left = 0;
        int right = N - 1;
        int[] liquid = new int[2];

        int tmp;
        while (left < right) {
            if (min == 0) return liquid;

            tmp = arr[left] + arr[right];
            int absT = Math.abs(tmp);
            if (absT < min) {
                min = absT;
                liquid[0] = arr[left];
                liquid[1] = arr[right];
            }

            if (tmp > 0) {
                right --;
            }
            else left++;
        }

        return liquid;

    }
}