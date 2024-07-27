import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long count = 0;
        long K = 1;

        while (N > 0) {
            if (N < K) {
                K = 1;
            }
            N -= K;
            K++;
            count++;
        }

        System.out.println(count);
    }
}