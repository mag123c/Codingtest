import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : a.toCharArray()) {
            if (c > 96) sb.append((char)(c - 32));
            else sb.append((char)(c + 32));
        }
        System.out.println(sb);
    }
}
