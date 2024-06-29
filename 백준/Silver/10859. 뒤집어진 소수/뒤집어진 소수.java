import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine().trim();
        long originNum = Long.parseLong(input);
        long reverseNum = reverse(originNum);

        if (reverseNum == -1) {
            System.out.println("no");
        }
        else {
            boolean isPrimeOrigin = isPrime(originNum);
            boolean isPrimeReverse = isPrime(reverseNum);
            if (isPrimeOrigin && isPrimeReverse) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isPrime(long number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (long i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static long reverse(long N) {
        long reverse = 0;
        while (N != 0) {
            long digit = N % 10;
            if (digit == 3 || digit == 4 || digit == 7) return -1;
            if (digit == 6) digit = 9;
            else if (digit == 9) digit = 6;
            reverse = reverse * 10 + digit;
            N /= 10;
        }
        return reverse;
    }
}
