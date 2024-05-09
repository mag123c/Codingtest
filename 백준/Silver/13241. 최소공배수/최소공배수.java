import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (a > b) {
            euclidean(a, b, bw);
        }
        else {
            euclidean(b, a, bw);
        }

        bw.flush();
        bw.close();
    }

    public static void euclidean(long a, long b, BufferedWriter bw) throws IOException {
        long tmpA = a;
        long tmpB = b;
        while(tmpA % tmpB != 0) {
            long aa = tmpA % tmpB;
            tmpA = tmpB;
            tmpB = aa;
        }

        print((a * b) / tmpB, bw);
    }


    public static void print(long number, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(number));
    }


}