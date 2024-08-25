import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            bw.write("String #" + (i + 1) + "\n");
            String next = br.readLine();
            for (int j = 0; j < next.length(); j++) {
                char c = next.charAt(j);
                if (c == 'Z') {
                    c = 'A';
                } else {
                    c = (char) (c + 1);
                }
                bw.write(c);                
            }
            bw.write("\n\n");
        }

        bw.flush();
        bw.close();
    }

}
