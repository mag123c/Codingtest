import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            int[] tmp = cd(n);
            int added = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= n / 2; i ++) {
                if (tmp[i] == 1) {
                    added += i;
                    sb.append(i).append(" + ");
                }
            }

            if (added != n) {
                bw.write(n + " is NOT perfect.");
            }
            else {
                bw.write(n + " = " + sb.toString().substring(0, sb.toString().length() - 3));
            }
            bw.newLine();
        }        

        bw.flush();
        bw.close();
    }

    private static int[] cd(int n) {
        int[] tmp = new int[n + 1];

        for (int i = 1; i <= n / 2; i ++) {
            if (n % i == 0) tmp[i]++;
        }
        return tmp;

    }
}
