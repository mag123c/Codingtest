import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int H;
    private static int W;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        String[] arr = new String[H];
        for (int i = 0; i < H; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            boolean chk = false;
            for (int j = 0; j < H; j++) {
                if (!arr[j].substring(i * W, (i + 1) * W).replaceAll("\\?", "").isEmpty()) {
                    String word = arr[j].substring(i * W, (i + 1) * W).replaceAll("\\?", "");
                    bw.write(word.charAt(0));
                    chk = true;
                    break;
                }
            }

            if (!chk) bw.write("?");
        }

        bw.flush();
        bw.close();
    }

}
