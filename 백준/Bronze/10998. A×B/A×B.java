import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        print(A * B, bw);

        bw.flush();
        bw.close();
    }

    public static void print(int number, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(number));
    }
}