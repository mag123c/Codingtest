import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] prime = findPrime(118);
        
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();

            boolean found = false;
            for (int j = 2; j <= a/2; j++) {
                if (prime[j] && prime[a - j]) {
                    found = true;
                    break;
                }
            }

            System.out.println(found ? "Yes" : "No");
        }
        sc.close();
    }

    private static boolean[] findPrime(int len) {
        boolean[] prime = new boolean[len + 1];
        Arrays.fill(prime, true);        
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= len; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= len; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }
}