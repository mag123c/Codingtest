import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
                bw.write(arr[r][idx] + "\n");
            }
            else {
                bw.write(arr[r][idx] - arr[l - 1][idx] + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int[][] countAlphabet(String word) {
        int length = word.length();
        int[][] prefixCount = new int[length][26];
        char[] chars = word.toCharArray();

        prefixCount[0][chars[0] - 'a'] = 1;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < 26; j++) {
                prefixCount[i][j] = prefixCount[i - 1][j];
            }
            prefixCount[i][chars[i] - 'a']++;
        }

        return prefixCount;
    }

}


