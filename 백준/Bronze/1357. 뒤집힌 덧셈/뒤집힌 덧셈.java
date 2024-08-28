import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println((rev(rev(N) + rev(M))));
    }

    private static int rev(int x) {
        StringBuilder sb = new StringBuilder();
        String reverse = sb.append(x).reverse().toString();

        return Integer.parseInt(reverse);
    }
}
