import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tile = new int[1000001];
        tile[1] = 1;
        tile[2] = 2;

        System.out.println(countSplitTile(tile, N));
    }

    private static int countSplitTile(int[] tile, int N) {
        for (int i = 3; i <= N; i ++) {
            tile[i] = (tile[i - 1] + tile[i - 2]) % 15746;
        }
        return tile[N];
    }
}
