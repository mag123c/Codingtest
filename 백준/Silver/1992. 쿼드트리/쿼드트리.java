import java.io.*;

public class Main {

    private static int N;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] quadTree = new int[N][N];

        for (int i = 0; i < N; i ++) {
            String line = br.readLine();
            for (int j = 0; j < N; j ++) {
                quadTree[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        recursive(quadTree, 0, 0, N);

        bw.flush();
        bw.close();
    }

    private static void recursive(int[][] quadTree, int a, int b, int N) throws IOException {
        if (N == 1 || isCompression(quadTree, a, b, N)) {
            if(quadTree[a][b] == 1) bw.write("1");
            else bw.write("0");
            return;
        }

        else bw.write("(");

        int newN = N / 2;
        recursive(quadTree, a, b, newN);
        recursive(quadTree, a, b + newN, newN);
        recursive(quadTree, a + newN, b, newN);
        recursive(quadTree, a + newN, b + newN, newN);
        bw.write(")");
    }

    private static boolean isCompression(int[][] quadTree, int a, int b, int N) {
        int comp = quadTree[a][b];
        for (int i = a; i < a + N; i ++) {
            for (int j = b; j < b + N; j ++) {
                if (comp != quadTree[i][j]) return false;
            }
        }

        return true;
    }
}
