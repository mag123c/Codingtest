import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        print((int) Math.pow(2, N) - 1 + "\n");
        hanoi(N, 1,2, 3);

        bw.flush();
        bw.close();
    }

    private static void hanoi(int N, int start, int mid, int end) throws IOException {
        if (N == 1) {
            print(start + " " + end + "\n");
            return;
        }

        hanoi(N - 1, start, end, mid);
        print(start + " " + end + "\n");
        hanoi(N - 1, mid, start, end);
    }


    private static void print(String value) throws IOException {
        bw.write(value);
    }
}
