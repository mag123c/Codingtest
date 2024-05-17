import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] prime = calculatePrime();

        for(int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            int goldbach = calculateGoldBach(num, prime);
            print(goldbach + "\n");

        }


        bw.flush();
        bw.close();
    }

    private static boolean[] calculatePrime() {
        int length = 1000000;
        boolean[] tmp = new boolean[length + 1];
        tmp[0] = tmp[1] = true;

        for (int i = 2; i * i <= length; i ++) {
            if (!tmp[i]) {
                for (int j = i * i; j <= length; j += i) {
                    tmp[j] = true;
                }
            }
        }
        return tmp;
    }

    private static int calculateGoldBach(int num, boolean[] prime) {
        int count = 0;

        for (int left = 1; left <= num / 2; left++) {
            int right = num - left;
            if (!prime[left] && !prime[right]) {
                count++;
            }
        }

        return count;
    }


    private static void print(Object o) throws IOException {
        bw.write(String.valueOf(o));
    }
}