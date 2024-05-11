import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] tmp = new int[N - 1];

        int total = 0;
        for (int i = 0; i < N - 1; i ++) {
            tmp[i] = arr[i + 1] - arr[i];
            total += tmp[i];
        }

        int gcd = euclidean(tmp[0], tmp[1]);
        for (int i = 2; i < N - 1; i ++) {
            gcd = euclidean(gcd, tmp[i]);
        }

        bw.write(String.valueOf((total - (gcd * tmp.length))  / gcd));


        bw.flush();
        bw.close();
    }

    public static int euclidean(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }


}