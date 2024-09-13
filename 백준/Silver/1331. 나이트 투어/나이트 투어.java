import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
    private static final int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] moves = new String[36];
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < 36; i++) {
            moves[i] = sc.next();
            visited.add(moves[i]);
        }

        if (visited.size() != 36) {
            System.out.println("Invalid");
            return;
        }

        for (int i = 0; i < 35; i++) {
            if (!isValidMove(moves[i], moves[i + 1])) {
                System.out.println("Invalid");
                return;
            }
        }

        if (!isValidMove(moves[35], moves[0])) {
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
        }
    }

    private static boolean isValidMove(String from, String to) {
        int x1 = from.charAt(0) - 'A'; // 행
        int y1 = from.charAt(1) - '1'; // 열
        int x2 = to.charAt(0) - 'A'; // 행
        int y2 = to.charAt(1) - '1'; // 열

        for (int i = 0; i < 8; i++) {
            if (x1 + dx[i] == x2 && y1 + dy[i] == y2) {
                return true;
            }
        }
        return false;
    }
}
