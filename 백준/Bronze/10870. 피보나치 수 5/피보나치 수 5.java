import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int fibo = calculateFibo(N);

        print(fibo);

        bw.flush();
        bw.close();
    }

    private static int calculateFibo(int N) {
        if (N == 0) return 0;
        else if (N == 1) return 1;
        else return calculateFibo(N -1) + calculateFibo(N -2);
    }

    private static void print(Object o) throws IOException {
        bw.write(String.valueOf(o));
    }
}