import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] sdoku = new int[9][9];

        for (int i = 0; i < 9; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j ++) {
                sdoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (playSdoku(sdoku)) {
            printSdoku(sdoku);
        }

        bw.flush();
        bw.close();

    }

    private static boolean playSdoku(int[][] sdoku) throws IOException {
        int[] empty = findEmpty(sdoku);
        if (empty[0] == -1 && empty[1] == -1) {
            return true;
        }

        for (int i = 1; i <= 9; i ++) {
            if (isValid(sdoku, empty[0], empty[1], i)) {
                sdoku[empty[0]][empty[1]] = i;
                if (playSdoku(sdoku)) {
                    return true;
                }
                sdoku[empty[0]][empty[1]] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] sdoku, int row, int col, int number) {
        // 1~9까지 같은 숫자가 있는지 (행/열)
        for(int i = 0; i < 9; i ++) {
            if (sdoku[row][i] == number || sdoku[i][col] == number) {
                return false;
            }
        }

        // 3x3에 같은 숫자가 있는지
        int rowSquare = (row / 3) * 3;
        int colSquare = (col / 3) * 3;
        for (int i = rowSquare; i < rowSquare + 3; i ++) {
            for (int j = colSquare; j < colSquare + 3; j ++) {
                if (sdoku[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printSdoku(int[][] sdoku) throws IOException {
        for(int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                print(sdoku[i][j] + " ");
            }
            bw.newLine();
        }
    }

    private static int[] findEmpty(int[][] sdoku) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (sdoku[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    private static void print(String value) throws IOException {
        bw.write(value);
    }
}
