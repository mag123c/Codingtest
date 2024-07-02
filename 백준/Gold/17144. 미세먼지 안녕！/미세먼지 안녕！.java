import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int R;
    private static int C;
    private static int T;
    private static int x1 = -1;
    private static int x2 = -1;
    private static int[] dx = { 0, 0, 1, -1 };
    private static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] room = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                if (room[i][j] == -1) {
                    if (x1 == -1) {
                        x1 = i;
                    } else {
                        x2 = i;
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            room = clean(propagation(room));            
        }

        int total = 0;
        for (int i = 0; i < R; i ++) {
            for (int j = 0; j < C; j ++) {
                if (room[i][j] != -1) {
                    total += room[i][j];
                }
            }
        }

        System.out.println(total);
    }

    private static int[][] clean(int[][] room) {
        for (int i = x1 - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            room[0][i] = room[0][i + 1];
        }
        for (int i = 0; i < x1; i++) {
            room[i][C - 1] = room[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            room[x1][i] = room[x1][i - 1];
        }
        room[x1][1] = 0;


        for (int i = x2 + 1; i < R - 1; i++) {
            room[i][0] = room[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            room[R - 1][i] = room[R - 1][i + 1];
        }
        for (int i = R - 1; i > x2; i--) {
            room[i][C - 1] = room[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            room[x2][i] = room[x2][i - 1];
        }
        room[x2][1] = 0;

        return room;
    }

    private static int[][] propagation(int[][] room) {
        int[][] tmp = new int[R][C];
        for (int i = 0; i < R; i ++) {
            tmp[i] = Arrays.copyOf(room[i], C);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] >= 5) {
                    int propaCnt = 0;
                    int spreadAmount = room[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int newX = i + dx[k];
                        int newY = j + dy[k];
                        if (isAvailable(newX, newY) && room[newX][newY] != -1) {
                            tmp[newX][newY] += spreadAmount;
                            propaCnt++;
                        }
                    }
                    tmp[i][j] -= spreadAmount * propaCnt;
                }
            }
        }

        return tmp;
    }

    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

}
