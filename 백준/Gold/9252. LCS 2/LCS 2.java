import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int aLen = a.length();
        int bLen = b.length();

        int[][] LCS = new int[aLen + 1][bLen + 1];
        
        for (int i = 1; i <= aLen; i ++) {
            for (int j = 1; j <= bLen; j ++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                }
                else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        System.out.println(LCS[aLen][bLen]);

        StringBuilder sb = new StringBuilder();
        while (true) {
            int cnt = LCS[aLen][bLen];
            if (cnt == 0) break;
            
            if (LCS[aLen - 1][bLen - 1] == cnt) {
                aLen--;
                bLen--;
            }
            else if (LCS[aLen - 1][bLen] == cnt) {
                aLen--;
            }
            else if (LCS[aLen][bLen - 1] == cnt) {
                bLen--;
            }
            else {
                cnt--;
                sb.append(b.charAt(bLen - 1));
                aLen--;
                bLen--;
            }
        }

        System.out.println(sb.reverse());

    }

}
