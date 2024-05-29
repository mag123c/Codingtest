import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int two = 0;
        int five = 0;

        for (int i = 2; i <= N; i *= 2) {
            two += N / i;
        }

        for (int i = 5; i <= N; i *= 5) {
            five += N / i;
        }

        System.out.println(Math.min(two, five));

    }
}