import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = 0;

        while(st.hasMoreTokens()) {
            int N = Integer.parseInt(st.nextToken());
            tmp += (int) Math.pow(N, 2);
        }
        System.out.println(tmp % 10);

    }
}