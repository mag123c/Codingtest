import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import static java.math.BigInteger.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] arr = new BigInteger[51];

        for (int i = 0; i <= 50; i ++) {
            arr[i] = valueOf((long) Math.pow(31, i));
        }

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] c = s.toCharArray();
        BigInteger answer = valueOf(0);
        for (int i = 0; i < N; i ++) {
            BigInteger tmp = arr[i].multiply(valueOf(c[i] - 'a' + 1));
            answer = answer.add(tmp);
        }
        System.out.println(answer);
    }
}