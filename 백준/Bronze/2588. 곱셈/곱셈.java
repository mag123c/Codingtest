import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int tmp1 = print(A, B, 1, bw);
        B -= B % 10;
        int tmp2 = print(A, B, 2, bw);
        B -= B % 100;
        int tmp3 = print(A, B, 3, bw);

        bw.write(String.valueOf(tmp1 + tmp2 + tmp3));

        bw.flush();
        bw.close();
    }

    public static int print(int A, int B, int exponent, BufferedWriter bw) throws IOException {
        int tmp = A * (B % (int) Math.pow(10, exponent));
        bw.write((int) (tmp / Math.pow(10, exponent - 1)) + "\n");
        return tmp;
    }
}