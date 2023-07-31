import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static int[] chk;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        chk = new int[M + 1];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i <N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, arr[0]);


        System.out.println(sb);
    }

    private static void dfs(int cnt, int current) {
        chk[cnt] = current;
        if(cnt == M) {
            for(int i = 1; i < chk.length; i ++) {
                sb.append(chk[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i ++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(cnt + 1, arr[i]);
            visited[i] = false;
        }
    }
}
