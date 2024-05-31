import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long[][] arr = new long[][]{{ 1, 1 }, { 1, 0 }};

        long[][] matrix = matrixPower(arr, N - 1);

        System.out.println(matrix[0][0] % MOD);
    }

    private static long[][] matrixPower(long[][] arr, long exp) {
        long[][] result = new long[][]{{ 1, 0 }, { 0, 1 }};
        long[][] base = arr;

        while (exp > 0) {
            if (exp % 2 != 0) {
                result = multiplyMatrix(result, base);
            }
            base = multiplyMatrix(base, base);
            exp /= 2;
        }

        return result;
    }

    private static long[][] multiplyMatrix(long[][] A, long[][] B) {
        long[][] result = new long[2][2];

        result[0][0] = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % MOD;
        result[0][1] = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % MOD;
        result[1][0] = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % MOD;
        result[1][1] = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % MOD;

        return result;
    }

}