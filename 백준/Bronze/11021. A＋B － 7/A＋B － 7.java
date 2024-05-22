import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 1; i <= N; i ++) {
            st = new StringTokenizer(br.readLine());
            int plus = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            bw.write("Case #" + i + ": " + plus + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
