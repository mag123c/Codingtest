import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        if (length % 5 == 0) {
            System.out.println(length / 5);
        }
        else {
            System.out.println(length / 5 + 1);
        }
    }
}
