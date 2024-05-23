import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int H;
        int W;
        int N;
        int height;
        int width;
        for (int i = 0; i < T; i ++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            height = 0;
            width = 1;

            for (int j = 0; j < N; j ++) {
                height++;

                if (height > H) {
                    height = 1;
                    width++;
                }
            }

            sb.append(height);

            if (width < 10) {
                sb.append("0");
            }
            sb.append(width).append("\n");
        }

        System.out.println(sb);
    }
}
