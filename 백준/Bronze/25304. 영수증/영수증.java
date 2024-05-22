import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            X -= tmp;
        }

        System.out.println(X == 0 ? "Yes" : "No");
    }
}
