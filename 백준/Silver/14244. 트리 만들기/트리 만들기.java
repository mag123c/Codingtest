import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n - m; i++) {
            result.append(i).append(" ").append(i + 1).append("\n");
        }

        for (int i = n - m + 1; i < n; i++) {
            result.append(n - m).append(" ").append(i).append("\n");
        }

        System.out.print(result);
    }
}
