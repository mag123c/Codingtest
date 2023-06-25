import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
                        bfs(cabbage, bl, j, k);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
        br.close();
    }

    private static void bfs(int[][] cabbage, boolean[][] bl, int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        bl[x][y] = true;

        int[] X = new int[]{-1, 1, 0, 0};
        int[] Y = new int[]{0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i=0; i<4; i++){
                int xx = poll[0] + X[i];
                int yy = poll[1] + Y[i];

                if(xx < 0 || xx >= bl.length || yy < 0 || yy >= bl[0].length) continue;

                if(cabbage[xx][yy] == 1 && !bl[xx][yy]){
                    queue.offer(new int[]{xx, yy});
                    bl[xx][yy] = true;
                }
            }
        }
    }

//    private static void dfs(int[][] cabbage, boolean[][] bl, int x, int y) {
//        if(x < 0 || x >= bl.length || y < 0 || y >= bl[0].length) return;
//        if(bl[x][y]) return;
//        bl[x][y] = true;
//        if(cabbage[x][y] == 1){
//            dfs(cabbage, bl, x+1, y);
//            dfs(cabbage, bl, x-1, y);
//            dfs(cabbage, bl, x, y+1);
//            dfs(cabbage, bl, x, y-1);
//        }
//    }
}
