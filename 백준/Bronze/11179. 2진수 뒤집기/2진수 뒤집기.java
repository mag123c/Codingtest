
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();

        String binary = Integer.toBinaryString(next);
        
        String reverse = new StringBuilder().append(binary).reverse().toString();

        System.out.println(Integer.parseInt(reverse, 2));

    }
}
