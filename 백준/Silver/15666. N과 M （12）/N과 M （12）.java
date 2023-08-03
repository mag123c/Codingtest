import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] chk;
    static LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        chk = new int[M];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        find(0, 0);

        for(String s : linkedHashSet) System.out.println(s);

    }

    private static void find(int idx, int cnt) {
        if (cnt == M) {
            StringBuilder tempSb = new StringBuilder();
            for (int i = 0; i < chk.length; i++) {
                tempSb.append(chk[i]).append(" ");
            }
            linkedHashSet.add(tempSb.toString());

            return;
        }

        for (int i = idx; i < N; i++) {
            chk[cnt] = arr[i];
            find(i, cnt + 1);
        }
    }
}
