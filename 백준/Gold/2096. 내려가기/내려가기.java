import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[][] reverse = new int[N][3];
        for (int i = 0; i  < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;

            reverse[i][0] = a;
            reverse[i][1] = b;
            reverse[i][2] = c;
        }

        dp(arr, reverse, N);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i ++) {
            min = Math.min(min, reverse[N - 1][i]);
            max = Math.max(max, arr[N - 1][i]);
        }

        System.out.print(max + " " + min);
    }

    private static void dp(int[][] arr, int[][] reverse, int N) {
        for (int i = 1; i < N; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (j == 1) {
                    arr[i][j] += Math.max(arr[i - 1][j - 1], Math.max(arr[i - 1][j], arr[i - 1][j + 1]));
                    reverse[i][j] += Math.min(reverse[i - 1][j - 1], Math.min(reverse[i - 1][j], reverse[i - 1][j + 1]));
                }
                else {
                    arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][1]);
                    reverse[i][j] += Math.min(reverse[i - 1][j], reverse[i - 1][1]);
                }
            }
        }
    }
}
