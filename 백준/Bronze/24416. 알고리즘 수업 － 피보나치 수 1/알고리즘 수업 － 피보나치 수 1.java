import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int recursiveCnt = 0;
    static int dpCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int rFibo = recursive(n);
        int dpFibo = dp(n);

        print(recursiveCnt / 2 + 1 + " " + dpCnt);

        bw.flush();
        bw.close();

    }

    private static int recursive(int n) {
        recursiveCnt++;
        if (n == 1 || n == 2) return 1;

        return (recursive(n - 2) + recursive(n - 1));
    }

    private static int dp(int n) {
        int[] fibo = new int[n + 1];
        fibo[1] = fibo[2] = 1;

        return findDp(fibo);
    }

    private static int findDp(int[] fibo) {
        for (int i = 3; i < fibo.length; i ++) {
            dpCnt++;
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }
        return fibo[fibo.length - 1];
    }


    private static void print(String value) throws IOException {
        bw.write(value);
    }
}
