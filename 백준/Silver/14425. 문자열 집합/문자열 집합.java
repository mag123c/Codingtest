import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> word = new HashSet<>();

        for (int i = 0; i < N; i ++) {
            word.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i ++) {
            if (word.contains(br.readLine())) {
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();

    }

}