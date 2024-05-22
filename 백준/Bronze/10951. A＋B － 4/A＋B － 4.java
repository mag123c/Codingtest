import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        StringTokenizer st;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int plus = a + b;
            bw.write(plus + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
