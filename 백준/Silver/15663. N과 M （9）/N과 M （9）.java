import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] mArr;
    static boolean[] visited;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        mArr = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        find(0);

        for(String s : set) System.out.println(s);
    }

    private static void find(int cnt) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for(int i : mArr) sb.append(i + " ");
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < N; i ++) {
            if(visited[i]) continue;

            visited[i] = true;
            mArr[cnt] = arr[i];
            find(cnt + 1);
            visited[i] = false;
        }
    }
}
