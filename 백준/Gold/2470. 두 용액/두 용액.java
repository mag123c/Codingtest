import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        twoPointer(arr);
    }

    private static void twoPointer(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int min = Integer.MAX_VALUE;

        int small = 0;
        int large = 0;

        while(left < right) {
            int tmp = arr[left] + arr[right];

            if (min > Math.abs(tmp)) {
                min = Math.abs(tmp);
                small = arr[left];
                large = arr[right];
            }

            if (tmp == 0) {
                System.out.print(small + " " + large);
                return;
            }

            if (tmp > 0) right--;
            else left++;
        }

        System.out.print(small + " " + large);
    }
}