import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] stars = new char[N][N];

        for (int i = 0; i < N; i ++) {
            Arrays.fill(stars[i], '*');
        }

        drawStars(0, 0, N, stars);

        for (char[] star: stars) {
            for (char s: star) {
                print(String.valueOf(s));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void drawStars(int x, int y, int N, char[][] stars) {
        if (N == 1) return;

        int subSize = N / 3;

        for (int i = x + subSize; i < x + 2 * subSize; i++) {
            for (int j = y + subSize; j < y + 2 * subSize; j++) {
                stars[i][j] = ' ';
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                drawStars(x + i * subSize, y + j * subSize, subSize, stars);
            }
        }
    }


    private static void print(String value) throws IOException {
        bw.write(value);
    }
}
