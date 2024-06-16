import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double ratio = Math.sqrt(Math.pow(H, 2) + Math.pow(W, 2));
        int height = (int) Math.floor(D * H / ratio);
        int width = (int) Math.floor(D * W / ratio);

        System.out.println(height + " " + width);
    }
}
