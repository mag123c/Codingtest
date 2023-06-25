import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] cabbage = new int[M][N];
            boolean[][] bl = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                cabbage[x][y] = 1;
            }
            int result = 0;
            for(int j = 0; j < cabbage.length; j++){
                for(int k = 0; k < cabbage[j].length; k++){
                    if(cabbage[j][k] == 1 && !bl[j][k]) {
                        dfs(cabbage, bl, j, k);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
        br.close();
    }

    private static void dfs(int[][] cabbage, boolean[][] bl, int x, int y) {
        if(x < 0 || x >= bl.length || y < 0 || y >= bl[0].length) return;
        if(bl[x][y]) return;
        bl[x][y] = true;
        if(cabbage[x][y] == 1){
            dfs(cabbage, bl, x+1, y);
            dfs(cabbage, bl, x-1, y);
            dfs(cabbage, bl, x, y+1);
            dfs(cabbage, bl, x, y-1);
        }
    }
}