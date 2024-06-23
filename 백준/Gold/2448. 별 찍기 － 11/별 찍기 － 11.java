import java.io.*;

public class Main {

    private static final String[] basePattern = {
            "  *  ",
            " * * ",
            "*****"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] result = generatePattern(N);
        for (String line : result) {
            bw.write(line + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static String[] generatePattern(int n) {
        if (n == 3) {
            return basePattern;
        }

        String[] prevPattern = generatePattern(n / 2);
        String[] newPattern = new String[n];

        int half = n / 2;

        for (int i = 0; i < half; i++) {
            newPattern[i] = " ".repeat(half) + prevPattern[i] + " ".repeat(half);
        }

        for (int i = 0; i < half; i++) {
            newPattern[half + i] = prevPattern[i] + " " + prevPattern[i];
        }

        return newPattern;
    }
}
