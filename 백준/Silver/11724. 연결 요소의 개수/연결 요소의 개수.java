import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        boolean[] bl = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        int chk = 0;
        for(int i = 1; i <= N; i ++) {
            if(!bl[i]){
                dfs(arr, bl, i);
                chk++;
            }
        }

        System.out.println(chk);

    }

    private static void dfs(int[][] arr, boolean[] bl, int idx) {

        if(bl[idx]) return;
        bl[idx] = true;

        for(int i = 1; i < arr.length; i++) {
            if(arr[idx][i] == 1 && !bl[i]) {
                dfs(arr, bl, i);
            }
        }

    }

}
