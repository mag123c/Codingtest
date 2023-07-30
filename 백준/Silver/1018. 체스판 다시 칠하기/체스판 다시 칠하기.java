import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = (readLine.charAt(j) == 'W') ? true : false;
            }
        }

        int min = 65;
        for(int i = 0; i <= N - 8; i ++) {
            for(int j = 0; j <= M - 8; j ++) {
                int cnt = 0;
                boolean color = arr[i][j];
                for(int k = i; k < i + 8; k ++) {
                    for(int l = j; l < j + 8; l ++) {
                        if(arr[k][l] != color) {
                            cnt++;
                        }
                        color = (!color);
                    }
                    color = (!color);
                }
                cnt = Math.min(cnt, 64 - cnt);

                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
    }
}
