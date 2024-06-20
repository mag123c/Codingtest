import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static int[][] dp;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i  < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 0;
            }
        }

        if (arr[N - 1][N - 1] == 1)  {
            System.out.println(0);
            return;
        }
        
        dp[0][0] = 0;
        dp[0][1] = 1;

        System.out.println(maxPipeMovement());
    }

    private static int maxPipeMovement() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 1, 0});

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i ++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int direction = cur[2];

                int commonX = cur[0] + 1;
                int commonY = cur[1] + 1;

                if (isAvailable(commonX, commonY) && isAvailable(x + 1, y) && isAvailable(x, y + 1)) {
                    dp[commonX][commonY]++;
                    q.offer(new int[] {commonX, commonY, 1});
                }

                //세로
                if (direction >= 1) {
                    commonX = cur[0] + 1;
                    commonY = cur[1];
                    if (isAvailable(commonX, commonY)) {
                        dp[commonX][commonY]++;
                        q.offer(new int[] {commonX, commonY, 2});
                    }
                }

                //가로
                if (direction <= 1) {
                    commonX = cur[0];
                    commonY = cur[1] + 1;
                    if (isAvailable(commonX, commonY)) {
                        dp[commonX][commonY]++;
                        q.offer(new int[]{commonX, commonY, 0});
                    }
                }
            }
        }

        return dp[N - 1][N - 1];
    }

    private static boolean isAvailable(int x, int y) {
        return x < N && y < N && arr[x][y] != 1;
    }
}
