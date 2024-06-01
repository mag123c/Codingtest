import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static ArrayList<Integer> homeCnt = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] land = new int[N][N];

        String line;
        for (int i = 0; i < N; i ++) {
            line = br.readLine();
            for (int j = 0; j < N; j ++) {
                land[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] isVisit = new boolean[N][N];

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j  < N; j ++) {
                if (land[i][j] == 1 && !isVisit[i][j]) {
                    int cnt = dfs(i, j, N, land, isVisit);
                    homeCnt.add(cnt);
                }
            }
        }

        Collections.sort(homeCnt);
        System.out.println(homeCnt.size());
        for (int i : homeCnt) {
            System.out.println(i);
        }
    }

    private static int dfs(int x, int y, int N, int[][] land, boolean[][] isVisit) {
        isVisit[x][y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i ++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (availableRange(newX, newY, N) && !isVisit[newX][newY] && land[newX][newY] == 1) {
                cnt += dfs(newX, newY, N, land, isVisit);
            }
        }

        return cnt;
    }

    private static boolean availableRange(int x, int y, int N) {
        if (x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }
}