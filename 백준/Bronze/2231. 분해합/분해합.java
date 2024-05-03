import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int size = 1;
        while(true) {
            if (N / getPow(10, size) == 0) break;
            size++;
        }

        int max = 9 * size;

        for (int i = N - max; i <= N; i ++) {
            int totalRemainder = 0;
            int tmp = i;

            for (int j = 1; j <= size; j ++) {
                int remainder = tmp % getPow(10, 1);
                tmp /= 10;
                totalRemainder += remainder;
            }


            if (i + totalRemainder == N) {
                System.out.println(i);
                return;
            }

        }

        System.out.println(0);
    }

    public static int getPow(int bottom, int exponent) {
        return (int) Math.pow(bottom, exponent);
    }

}
