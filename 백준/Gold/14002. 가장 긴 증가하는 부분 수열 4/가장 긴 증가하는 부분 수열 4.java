import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] tmp = new int[N];
        int maxLen = 1;
        int end = 0;
        Arrays.fill(tmp, -1);

        for (int i = 0; i < N; i ++) {
            dp[i] = 1;

            for (int j = 0; j < i; j ++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    tmp[i] = j;
                }
                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                    end = i;
                }
            }

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(maxLen + "\n");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = end; i >= 0; i = tmp[i]) {
            list.add(arr[i]);
            if (tmp[i] == -1) break;
        }

        Collections.reverse(list);

        for (int i : list) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();

    }

}
