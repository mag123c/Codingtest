import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] words = word.replaceAll("-", " ").split(" ");

        int cnt = 0;
        int len = words.length;
        for (int i = 0; i < len; i++) {
            if (words[i].contains("'") && isSplit(words[i].split("'")[0], words[i].split("'")[1])) {
                cnt++;
            }
        }

        System.out.println(cnt + len);
    }

    private static boolean isSplit(String word, String word2) {
        return (word.equals("c") || word.equals("j") || word.equals("n")
                || word.equals("m") || word.equals("t") || word.equals("s") || word.equals("l")
                || word.equals("d") || word.equals("d") || word.equals("qu") || word.equals("s"))
                && (word2.startsWith("a") || word2.startsWith("o") || word2.startsWith("u")
                        || word2.startsWith("i") || word2.startsWith("e") || word2.startsWith("h"));
    }
}
