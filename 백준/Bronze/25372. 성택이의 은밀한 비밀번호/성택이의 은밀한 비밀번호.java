import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i ++) {
            String s = br.readLine();

            if (s.length() >= 6 && s.length() <= 9) System.out.println("yes");
            else System.out.println("no");
        }
    }
}