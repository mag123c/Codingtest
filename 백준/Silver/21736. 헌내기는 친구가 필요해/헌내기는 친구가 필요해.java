import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    private static int N;
    private static int M;

    private static char[][] campus;
    private static boolean[][] isVisit;
    private static int dx = -1;
    private static int dy = -1;
    private static int[] dxdy = {-1, 1, 0, 0};
    private static int[] dydx = {0, 0, -1, 1};
    private static Queue<int[]> queue = new LinkedList<>();
    private static int meetFriend = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        isVisit = new boolean[N][M];
        for (int i = 0; i < N; i ++) {
            campus[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j ++) {
                if (dx == -1 && campus[i][j] == 'I') {
                    dx = i;
                    dy = j;
                    break;
                }
            }
        }

        queue.add(new int[] {dx, dy});
        isVisit[dx][dy] = true;
        findFriend(dx, dy);

        System.out.println(meetFriend == 0 ? "TT" : meetFriend);
    }

    private static void findFriend(int row, int col) {
        if (row < 0 || col < 0 || row >= N || col >= M) {
            return;
        }

        char tmp;
        while(!queue.isEmpty()) {
            int[] xy = queue.poll();

            for (int i = 0; i < 4; i ++) {
                int newX = xy[0] + dxdy[i];
                int newY = xy[1] + dydx[i];

                if (availableRange(newX, newY) && !isVisit[newX][newY]) {
                    isVisit[newX][newY] = true;
                    tmp = campus[newX][newY];
                    if (tmp == 'X') {
                        continue;
                    }

                    if (tmp == 'P') {
                        meetFriend++;
                    }
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    private static boolean availableRange(int row, int col) {
        if (row < 0 || col < 0 || row >= N || col >= M) {
            return false;
        }
        return true;
    }
}