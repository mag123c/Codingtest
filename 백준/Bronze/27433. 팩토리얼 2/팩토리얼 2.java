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

        long factorialNum = calculateFactorial(N);

        print(factorialNum);

        bw.flush();
        bw.close();
    }

    private static long calculateFactorial(int N) {
        if (N == 0) return 1;
        return N * calculateFactorial(N - 1);
    }

    private static void print(Object o) throws IOException {
        bw.write(String.valueOf(o));
    }
}