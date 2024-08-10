import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long length = (long) Math.pow(10, 16);
        List<Long> fibo = new ArrayList<>();
        fibo.add(1L);
        fibo.add(1L);

        while(true) {
            long next = fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2);
            if (next > 1e16) {
                break;
            }
            fibo.add(next);
        }
  

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            boolean found = false;
            if (k == 1) {
                if (fibo.contains(x)) {
                    found = true;
                }
            }

            else if (k == 2) {
                for (Long f: fibo) {
                    if (fibo.contains(x - f)) {
                        found = true;
                        break;
                    }                    
                }
            }
            
            else {
                for (Long f1: fibo) {
                    for (Long f2: fibo) {
                        if (fibo.contains(x - f1 - f2)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
            }

            if (found) {
                bw.write("YES");
            }
            else bw.write("NO");

            bw.newLine();
        }

        bw.flush();
        bw.close();

    }

}
