import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        tomo(A, B, C);
    }

    private static void tomo(int A, int B, int C) {
        int count = 0;
        int cLen = String.valueOf(C).length();
        String c = String.valueOf(C);
        int mod = (int) Math.pow(10, cLen);

        long currentValue = A;

        while (count <= 50000) {
            currentValue = (currentValue * B) % mod;
            count++;

            if (String.valueOf(currentValue).endsWith(c)) {
                System.out.println(count);
                return;
            }
        }

        System.out.println("NIKAD");
    }
}
