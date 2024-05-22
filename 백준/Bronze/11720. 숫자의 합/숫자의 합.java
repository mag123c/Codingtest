import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int answer = 0;

        for (String s : word.split("")) {
            int num = Integer.parseInt(s);
            answer += num;
        }

        System.out.println(answer);

    }
}