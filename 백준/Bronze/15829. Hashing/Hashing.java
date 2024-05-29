import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] c = s.toCharArray();

        BigInteger hash = BigInteger.valueOf(0);
        for (int i = 0; i < N; i ++) {
            hash = hash.add(BigInteger.valueOf(c[i] - 96).multiply(BigInteger.valueOf(31).pow(i)));
        }

        System.out.println(hash.remainder(BigInteger.valueOf(1234567891)));
    }
}