import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int count = 1;
        int startNum = 666;

        while(count < N) {
            startNum++;

            if (Integer.toString(startNum).contains("666")) {
                count++;
            }
        }

        System.out.println(startNum);

    }


}
