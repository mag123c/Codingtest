import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb);
    }

    private static void dfs(int now, int idx) {
        if(idx >= arr.length) {
            for(int i : arr) sb.append(i + " ");

            sb.append("\n");
            return;
        }

        for(int i = now; i <= N; i++) {
            arr[idx] = i;
            dfs(i + 1, idx + 1);
        }
    }
}
