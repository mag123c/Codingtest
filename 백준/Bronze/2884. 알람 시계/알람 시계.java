import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) - 45;

        if (M < 0) {
            H = (H - 1 < 0) ? 23 : H - 1;
            M += 60;
        }

        print(H + " " + M, bw);


        bw.flush();
        bw.close();
    }

    public static void print(String tmp, BufferedWriter bw) throws IOException {
        bw.write(tmp);
    }
}