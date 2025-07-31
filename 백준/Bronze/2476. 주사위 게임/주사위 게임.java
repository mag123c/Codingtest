import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int maxPrize = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int prize;
            if (a == b && b == c) {
                prize = 10000 + a * 1000;
            } else if (a == b || a == c) {
                prize = 1000 + a * 100;
            } else if (b == c) {
                prize = 1000 + b * 100;
            } else {
                int max = Math.max(a, Math.max(b, c));
                prize = max * 100;
            }

            if (prize > maxPrize) maxPrize = prize;
        }

        System.out.println(maxPrize);
    }
}
