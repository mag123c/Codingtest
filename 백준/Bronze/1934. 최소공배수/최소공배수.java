import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > b) {
                euclidean(a, b, bw);
            }
            else {
                euclidean(b, a, bw);
            }
        }

        bw.flush();
        bw.close();
    }

    public static void euclidean(int a, int b, BufferedWriter bw) throws IOException {
        int tmpA = a;
        int tmpB = b;
        while(tmpA % tmpB != 0) {
            int aa = tmpA % tmpB;
            tmpA = tmpB;
            tmpB = aa;
        }

        print((a * b) / tmpB, bw);
    }


    public static void print(int number, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(number) + "\n");
    }


}