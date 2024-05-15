import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i ++) {
            long targetNum = Long.parseLong(br.readLine());

            long nextPrimeNum = calNextPrime(targetNum);
            print(nextPrimeNum + "\n", bw);
        }

        bw.flush();
        bw.close();
    }

    private static long calNextPrime(long targetNum) {
        while(true) {
            if (isPrime(targetNum)) {
                return targetNum;
            }
            targetNum++;
        }
    }

    private static boolean isPrime(long currentNum) {
        if (currentNum <= 1) return false;

        for (int i = 2; i <= Math.sqrt(currentNum); i ++) {
            if (currentNum % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void print(String tmp, BufferedWriter bw) throws IOException {
        bw.write(tmp);
    }
}