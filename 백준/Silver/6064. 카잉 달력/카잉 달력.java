import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][4];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i ++) {
            keyingCalendar(arr[i][0], arr[i][1], arr[i][2], arr[i][3]);
        }

        bw.flush();
        bw.close();
    }

    private static void keyingCalendar(int X, int Y, int x, int y) throws IOException {
        int lcm = calLcm(X, Y);

        for (int i = x; i <= lcm; i += X) {
            if ((i - 1) % Y + 1 == y) {
                bw.write(i + "\n");
                return;
            }
        }
        bw.write(-1 + "\n");
    }

    private static int calLcm(int X, int Y) {
        int gcd = calGcd(X, Y);
        return X * Y / gcd;
    }

    private static int calGcd(int X, int Y) {
        while(Y != 0) {
            int tmp = X % Y;
            X = Y;
            Y = tmp;
        }
        return X;
    }
}