import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] zero;
    private static int[] one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int max = 0;

        fibo();

        for (int i = 0; i < T; i++) {
            int testcase = Integer.parseInt(br.readLine());
            System.out.println(zero[testcase] + " " + one[testcase]);
        }
    }

    private static void fibo() {
        zero = new int[41];
        one = new int[41];

        zero[0] = 1;
        one[0] = 0;
        zero[1] = 0;
        one[1] = 1;

        for(int i = 2; i <= 40; i ++) {
            zero[i] = zero[i - 2] + zero[i - 1];
            one[i] = one[i - 2] + one[i - 1];
        }
    }
}