import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(factorial(N) / (factorial(K) * (factorial(N - K))));
    }

    private static int factorial(int num) {
        int fac = 1;

        for (int i = 2; i <= num; i ++) {
            fac *= i;
        }

        return fac;
    }
}