import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] arr = countAlphabet(word);

        StringTokenizer st;
        String a;
        int l;
        int r;
        int cnt;
        for (int i = 0; i < q; i ++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            cnt = 0;

            for (int j = l; j <= r; j ++) {
                cnt += arr[j][a.charAt(0) - 97];
            }

            System.out.println(cnt);
        }

    }

    private static int[][] countAlphabet(String word) {
        int[][] arr = new int[word.length()][26];
        char[] c = word.toCharArray();

        for (int i = 0; i < word.length(); i ++) {
            int alpNum = c[i] - 97;
            arr[i][alpNum]++;
        }

        return arr;
    }

}