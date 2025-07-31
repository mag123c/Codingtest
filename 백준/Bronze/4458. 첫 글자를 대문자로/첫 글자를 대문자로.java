import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i ++) {
            String line = br.readLine();
            sb.append(line.substring(0, 1).toUpperCase() + line.substring(1)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
