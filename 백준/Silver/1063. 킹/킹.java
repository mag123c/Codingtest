import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static class Position {
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static Position king, stone;
    private static String[] commands;
    private static int commandCount;
    private static final int[] dRow = { 0, -1, -1, -1, 0, 1, 1, 1 };  // L, LT, T, RT, R, RB, B, LB
    private static final int[] dCol = { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        king = convertIndexToPosition(tokenizer.nextToken());
        stone = convertIndexToPosition(tokenizer.nextToken());
        commandCount = Integer.parseInt(tokenizer.nextToken());

        commands = new String[commandCount];
        for (int i = 0; i < commandCount; i++) {
            String command = reader.readLine();
            int direction = getDirection(command);
            boolean isStoneBlocking = isStoneInDirection(direction);
            move(direction, isStoneBlocking);
        }

        writer.write(convertPositionToIndex(king) + "\n" + convertPositionToIndex(stone));
        writer.flush();
        writer.close();
        reader.close();
    }

    private static Position convertIndexToPosition(String index) {
        int col = index.charAt(0) - 'A';
        int row = 8 - (index.charAt(1) - '0');
        return new Position(row, col);
    }

    private static String convertPositionToIndex(Position position) {
        char col = (char) (position.col + 'A');
        char row = (char) (8 - position.row + '0');
        return "" + col + row;
    }

    private static int getDirection(String command) {
        switch (command) {
            case "L": return 0;
            case "LT": return 1;
            case "T": return 2;
            case "RT": return 3;
            case "R": return 4;
            case "RB": return 5;
            case "B": return 6;
            case "LB": return 7;
            default: throw new IllegalArgumentException("Invalid command");
        }
    }

    private static boolean isStoneInDirection(int direction) {
        int nextRow = king.row + dRow[direction];
        int nextCol = king.col + dCol[direction];
        return stone.row == nextRow && stone.col == nextCol;
    }

    private static void move(int direction, boolean withStone) {
        if (withStone) {
            int nextStoneRow = stone.row + dRow[direction];
            int nextStoneCol = stone.col + dCol[direction];

            if (!isWithinBounds(nextStoneRow, nextStoneCol)) {
                return;
            }
            stone.row = nextStoneRow;
            stone.col = nextStoneCol;
        }

        int nextKingRow = king.row + dRow[direction];
        int nextKingCol = king.col + dCol[direction];

        if (!isWithinBounds(nextKingRow, nextKingCol)) {
            return;
        }
        king.row = nextKingRow;
        king.col = nextKingCol;
    }

    private static boolean isWithinBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}
