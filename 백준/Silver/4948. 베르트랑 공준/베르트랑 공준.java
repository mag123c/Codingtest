import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            boolean[] arr = calPrimeNum();
            print(betweenPrimeNum(N, arr) + "\n", bw);
        }
        bw.flush();
        bw.close();
    }

    private static boolean[] calPrimeNum() {
        boolean[] arr = new boolean[123456 * 2 + 1];
        arr[0] = arr[1] = true;
        for(int i = 2; i <= Math.sqrt(123456 * 2); i ++) {
            if (!arr[i]) {
                for (int j = i * i; j <= 123456 * 2; j += i) {
                    arr[j] = true;
                }
            }
        }

        return arr;
    }

    private static int betweenPrimeNum(int N, boolean[] arr) {
        int cnt = 0;
        for (int i = N + 1; i <= 2 * N; i++) {
            if(!arr[i]) cnt++;
        }

        return cnt;
    }

    public static void print(String tmp, BufferedWriter bw) throws IOException {
        bw.write(tmp);
    }
}