import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.close();

        boolean[] isPrime = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        if (primes.isEmpty()) {
            System.out.println(-1);
        } else {
            int sum = 0;
            int minPrime = primes.get(0);

            for (int prime : primes) {
                sum += prime;
            }

            System.out.println(sum);
            System.out.println(minPrime);
        }
    }
}
