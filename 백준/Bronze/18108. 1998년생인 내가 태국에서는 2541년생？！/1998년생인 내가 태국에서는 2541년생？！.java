import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(br.readLine());

        print(year, bw);

        bw.flush();
        bw.close();
    }

    public static void print(int tmp, BufferedWriter bw) throws IOException {
        bw.write(String.valueOf(tmp - 543));
    }
}