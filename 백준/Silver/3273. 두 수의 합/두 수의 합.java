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
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        System.out.println(twoPointer(arr, x));
    }

    private static int twoPointer(int[] arr, int sum) {
        int left = 0;
        int right = arr.length - 1;
        int cnt = 0;

        while(left < right) {
            int tmp = arr[left] + arr[right];

            if (tmp == sum) {
                left++;
                right--;
                cnt++;
            }
            else if (tmp < sum) {
                left++;
            }
            else {
                right--;
            }
        }
        return cnt;
    }
}