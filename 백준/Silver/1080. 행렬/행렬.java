import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int rows;
    private static int cols;
    private static int[][] currentMap;
    private static int[][] targetMap;
    private static int flipCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        rows = Integer.parseInt(tokenizer.nextToken());
        cols = Integer.parseInt(tokenizer.nextToken());
        currentMap = new int[rows][cols];
        targetMap = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String rowInput = reader.readLine();
            for (int j = 0; j < cols; j++) {
                currentMap[i][j] = Character.getNumericValue(rowInput.charAt(j));
            }
        }

        for (int i = 0; i < rows; i++) {
            String rowInput = reader.readLine();
            for (int j = 0; j < cols; j++) {
                targetMap[i][j] = Character.getNumericValue(rowInput.charAt(j));
            }
        }

        flipCount = 0;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (currentMap[i][j] != targetMap[i][j]) {
                    flipMatrix(i, j);
                    flipCount++;
                }
            }
        }

        if (areMapsIdentical()) {
            System.out.println(flipCount);
        } else {
            System.out.println(-1);
        }
    }

    private static void flipMatrix(int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                currentMap[i][j] ^= 1;  
            }
        }
    }

    private static boolean areMapsIdentical() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (currentMap[i][j] != targetMap[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
