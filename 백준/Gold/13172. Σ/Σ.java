import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static final BigInteger MOD = new BigInteger("1000000007");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < M; i++) {
            BigInteger Ni = scanner.nextBigInteger();
            BigInteger Si = scanner.nextBigInteger();
            BigInteger NiInverse = Ni.modInverse(MOD);
            result = result.add(Si.multiply(NiInverse)).mod(MOD);
        }

        System.out.println(result);
        scanner.close();
    }
}
