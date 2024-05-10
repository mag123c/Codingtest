import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int lcm = (b * d) / euclidean(b, d);

        int numerator = a * (lcm / b) + c * (lcm / d);

        int gcdNumerator = euclidean(numerator, lcm);

        bw.write(numerator / gcdNumerator + " " + lcm / gcdNumerator);

        bw.flush();
        bw.close();
    }

    public static int euclidean(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }


}