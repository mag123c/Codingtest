import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 0;
        int s = 0;
        int m = 0;
        int year = 0;
        while(E != e || S != s || M != m) {
            e = e < 15 ? e + 1 : 1;
            s = s < 28 ? s + 1 : 1;
            m = m < 19 ? m + 1 : 1;
            year++;            
        }

        System.out.println(year);
    }
}
