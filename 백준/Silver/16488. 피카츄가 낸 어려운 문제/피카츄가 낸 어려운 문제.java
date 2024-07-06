import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long N = scanner.nextLong();
        long K = scanner.nextLong();
        
        BigInteger tmp = BigInteger.valueOf(N);
        tmp = tmp.multiply(BigInteger.valueOf(K)).multiply(BigInteger.valueOf(N));

        System.out.println(tmp);
    }
}