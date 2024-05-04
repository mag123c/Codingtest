import java.io.*;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        HashSet<String> letter = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length() - i; j++) {
                letter.add(word.substring(j, j + i + 1));
            }
        }

        bw.write(String.valueOf(letter.size()));

        bw.flush();
        bw.close();

    }

}