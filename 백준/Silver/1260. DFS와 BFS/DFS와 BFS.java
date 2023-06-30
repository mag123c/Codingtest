import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        boolean[] dfs = new boolean[N+1];
        boolean[] bfs = new boolean[N+1];
        dfs[V] = bfs[V] = true;
        Queue<Integer> que = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }
        sb.append(V+ " ");
        dfs(arr, dfs, V, sb);

        sb.append("\n" + V + " ");
        que.add(V);
        bfs(arr, bfs, que, V, sb);

        System.out.println(sb.toString());
    }

    private static void dfs(int[][] arr, boolean[] dfs, int v, StringBuffer sb) {
        for(int i = 0; i <arr[v].length; i ++){
            if(arr[v][i] == 1 && !dfs[i]){
                sb.append(i + " ");
                dfs[i] = true;
                dfs(arr, dfs, i, sb);
            }
        }
    }

    private static void bfs(int[][] arr, boolean[] bfs, Queue<Integer> que, int v, StringBuffer sb) {
        while(!que.isEmpty()) {
            int x = que.poll();

            for(int i = 0; i < arr.length; i++) {
                if(arr[x][i] == 1 && !bfs[i]){
                    sb.append(i + " ");
                    bfs[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
