import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int calls = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int isPalindrome = isPalindrome(word);

            print(isPalindrome + " " + calls + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int isPalindrome(String word) {
        calls = 0;
        return recursion(word, 0, word.length() - 1);
    }

    private static int recursion(String word, int start, int end) {
        calls++;
        if (start >= end) return 1;
        else if (word.charAt(start) != word.charAt(end)) return 0;
        else return recursion(word, start + 1, end - 1);
    }

    private static void print(Object o) throws IOException {
        bw.write(String.valueOf(o));
    }
}