import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static StringBuilder sb = new StringBuilder();    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] sdoku = new int[9][9];
        for (int i = 0; i < 9; i ++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j ++) {
                sdoku[i][j] = line.charAt(j) - '0';
            }
        }

        sdoku(0, 0, sdoku);
   
    }

    private static void sdoku(int x, int y, int[][] sdoku) {
        if (y == 9) {
            sdoku(x + 1, 0, sdoku);
            return;
        }

        if (x == 9) {
            for (int[] sd: sdoku) {
                for (int s: sd) {
                    sb.append(s);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (sdoku[x][y] != 0) {
            sdoku(x, y + 1, sdoku);
            return;
        }

        for (int i = 1; i <= 9; i ++) {
            if (isPossible(x, y, i, sdoku)) {
                sdoku[x][y] = i;
                sdoku(x, y + 1, sdoku);
            }
            sdoku[x][y] = 0;
        }
    }

    private static boolean isPossible(int x, int y, int num, int[][] sdoku) {
        for (int i = 0; i < 9; i ++) {
            if (sdoku[x][i] == num || sdoku[i][y] == num) return false;
        }

        int tmpX = (x / 3) * 3;
        int tmpY = (y / 3) * 3;

        for (int i = tmpX; i < tmpX + 3; i ++) {
            for (int j = tmpY; j < tmpY + 3; j ++) {
                if (sdoku[i][j] == num) return false;
            }
        }

        return true;
    }
}
