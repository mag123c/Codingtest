import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int gcd = gcd(Math.abs(x), Math.abs(y));
            int gx = x / gcd;
            int gy = y / gcd;
            set.add(gx + "," + gy);
        }

        System.out.println(set.size());

    }

    private static int gcd(int x, int y) {
        while(y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

}
