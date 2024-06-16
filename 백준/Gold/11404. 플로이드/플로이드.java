import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] city = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i ++) {
            for (int j = 0; j <= N; j ++) {
                if (i == j) city[i][j] = 0;
                else city[i][j] = INF;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (city[start][end] > cost) {
                city[start][end] = cost;
            }
        }

        floydWarshall(city, N);

        for (int i = 1; i <= N; i ++) {
            for (int j = 1; j <= N; j ++) {
                if (city[i][j] == INF) {
                    bw.write(0 + " ");
                }
                else bw.write(city[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void floydWarshall(int[][] city, int N) {
        for (int tmp = 1; tmp <= N; tmp ++) {
            for (int i = 1; i <= N; i ++) {
                for (int j = 1; j <= N; j ++) {
                    if (city[i][tmp] != INF && city[tmp][j] != INF) {
                        city[i][j] = Math.min(city[i][j], city[i][tmp] + city[tmp][j]);
                    }
                }
            }
        }
    }
}
