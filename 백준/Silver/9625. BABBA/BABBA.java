import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] frequency = new int[T + 1][2];
        frequency[1][1] = 1;

        for (int i = 2; i <= T; i ++) {
            frequency[i][0] = frequency[i - 1][1];
            frequency[i][1] = frequency[i - 1][0] + frequency[i - 1][1];
        }

        System.out.println(frequency[T][0] + " " + frequency[T][1]);
    }
}
