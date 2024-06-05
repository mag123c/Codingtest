import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;

        for (int i = 0; i < 3; i ++) {
            String next = br.readLine();

            if (!next.equals("Fizz") && !next.equals("Buzz") && !next.equals("FizzBuzz")) {
                num = Integer.parseInt(next) + (3 - i);
            }
        }

        if (num % 3 == 0 && num % 5 == 0) System.out.println("FizzBuzz");
        else if (num % 3 == 0) System.out.println("Fizz");
        else if (num % 5 == 0) System.out.println("Buzz");
        else System.out.println(num);
    }
}
