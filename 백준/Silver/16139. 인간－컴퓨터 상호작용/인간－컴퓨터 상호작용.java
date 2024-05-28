
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
        char a;
        int l;
        int r;
        int idx;
        for (int i = 0; i < q; i ++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken().charAt(0);
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            idx = a - 'a';

            if (l == 0) {
                System.out.println(arr[r][idx]);
            }
            else {
                System.out.println(arr[r][idx] - arr[l - 1][idx]);
            }
        }

    }

    private static int[][] countAlphabet(String word) {
        int[][] arr = new int[word.length()][26];
        char[] c = word.toCharArray();
        int len = word.length();

        for (int i = 0; i < len; i ++) {
            if (i > 0) {
                System.arraycopy(arr[i - 1], 0, arr[i], 0, 26);
            }
            int alpNum = c[i] - 97;
            arr[i][alpNum]++;
        }

        return arr;
    }

}


