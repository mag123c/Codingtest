import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int size = 4 * (T - 1) + 1;
        char[][] arr = new char[size][size];
        for (char[] c : arr) {
            Arrays.fill(c, ' ');
        }

        drawStar(arr, T, 0, 0, size);

        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        for (char[] c: arr) {
            for (char cc: c) {
                bw.write(cc);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void drawStar(char[][] arr, int T, int x, int y, int size) {
        if (T == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = 4 * (T - 1) + 1;

        for (int i = 0; i < newSize; i++) {
            arr[x][y + i] = '*';
            arr[x + i][y] = '*';
            arr[x + newSize - 1][y + i] = '*';
            arr[x + i][y + newSize - 1] = '*';
        }

        drawStar(arr, T - 1, x + 2, y + 2, size);

    }
}
