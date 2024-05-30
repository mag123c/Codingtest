import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] matrix;
    private static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long [][] arr = new long[N][N];
        matrix = new int[N][N];

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] matrix = matrixPower(arr, B, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(matrix[i][j] % MOD + " ");
            }
            bw.newLine();
        }
        bw.flush();

    }

    private static long[][] matrixPower(long[][] arr, long exp, int N) {
        if (exp == 1) {
            return arr;
        }

        long[][] half = matrixPower(arr, exp / 2, N);
        half = multiplyMatrix(half, half, N);

        if (exp % 2 != 0) {
            half = multiplyMatrix(half, arr, N);
        }

        return half;
    }

    private static long[][] multiplyMatrix(long[][] A, long[][] B, int N) {
        long[][] result = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = 0;
                for (int k = 0; k < N; k++) {
                    result[i][j] += (A[i][k] * B[k][j]);
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }

}