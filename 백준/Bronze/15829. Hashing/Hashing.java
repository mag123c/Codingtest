import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] wordToChars = br.readLine().toCharArray();
        long num = 0;
        long r = 1;

        for (int i = 0; i < L; i++) {
            int val = wordToChars[i] - 'a' + 1;
            num += val * r;
            r *= 31;
        }

        System.out.println(num);
    }
}
