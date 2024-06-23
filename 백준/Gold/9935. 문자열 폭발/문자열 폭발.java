import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        String c4 = br.readLine();
        int c4Len = c4.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            result.append(word.charAt(i));
            if (result.length() >= c4Len && result.substring(result.length() - c4Len).equals(c4)) {
                result.setLength(result.length() - c4Len);
            }
        }

        if (result.length() > 0) {
            bw.write(result.toString());
        } else {
            bw.write("FRULA");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
