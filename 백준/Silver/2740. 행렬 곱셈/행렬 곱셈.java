import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr1= new int[N][M];

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j ++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr2 = new int[M][K];
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j ++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < K; j ++) {
                int sum = 0;
                for (int k = 0; k < M; k ++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                bw.write(sum + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
