import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        print((A + B) % C, bw);
        print(((A % C) + (B % C)) % C, bw);
        print (A * B % C, bw);
        print(((A % C) * (B % C)) % C, bw);

        bw.flush();
        bw.close();
    }

    public static void print(int tmp, BufferedWriter bw) throws IOException {
        bw.write(tmp + "\n");
    }
}