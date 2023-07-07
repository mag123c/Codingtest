import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] route = new int[N][N];

        for(int i = 0 ; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N; j ++) {
                route[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < N; i ++) {
            for(int j = 0 ; j < N; j ++) {
                for(int k = 0; k < N; k ++) {
                    if(route[j][i] == 1 && route[i][k] == 1) route[j][k] = 1;
                }
            }
        }

        for(int i = 0 ; i < N; i ++) {
            StringBuffer sb = new StringBuffer();
            for(int j = 0 ; j < N; j ++) {
                sb.append(route[i][j] + " ");
            }
            System.out.println(sb.toString());
        }
    }

}
