import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] len = new int[N];

        for (int i = 0; i < N - 1; i ++) {
            int before = Integer.parseInt(s[i]);
            int after = Integer.parseInt(s[i + 1]);

            if (after - before > 0) {
                len[i + 1] = len[i] + after - before;
            }
        }

        Arrays.sort(len);

        System.out.println(len[N - 1]);
    }
}
