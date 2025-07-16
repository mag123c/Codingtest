import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String fileName = br.readLine();
        char[] charArray = fileName.toCharArray();

        for (int i = 0; i < N - 1; i ++) {
            fileName = br.readLine();

            for (int j = 0; j < charArray.length; j ++) {
                if (charArray[j] != fileName.charAt(j)) {
                    charArray[j] = '?';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c: charArray) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}

