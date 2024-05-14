import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i ++) {
            print(T + " * " + i + " = " + T * i + "\n", bw);
        }


        bw.flush();
        bw.close();
    }

    public static void print(String tmp, BufferedWriter bw) throws IOException {
        bw.write(tmp);
    }
}