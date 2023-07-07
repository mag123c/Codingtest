import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] discussing = new int[N][2];
        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            discussing[i][0] = Integer.parseInt(st.nextToken());
            discussing[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(discussing, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });

        int end = discussing[0][1];
        int cnt = 1;
        for(int i = 1; i < discussing.length; i ++) {
            if(end <= discussing[i][0]) {
                cnt++;
                end = discussing[i][1];
            }
        }
        System.out.println(cnt);
    }

}
