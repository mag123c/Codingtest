import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int A_TO_Z = 'z'-'a'+1;
    private static final int WORD_LIMIT = 200000;

    private boolean isValid(byte[] word, byte[] board) {
        for (int i = 0; i < A_TO_Z; i++) {
            if (board[i] < word[i]) return false;
        }
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[][] wordsCnt = new byte[WORD_LIMIT][A_TO_Z];
        int n = 0;

        while (true) {
            String word = br.readLine();
            if (word.equals("-")) break;
            for (int i = 0; i < word.length(); i++)
                wordsCnt[n][word.charAt(i)-'A']++;
            n++;
        }

        StringBuilder answer = new StringBuilder();
        while (true) {
            String board = br.readLine();
            if (board.equals("#")) break;
            byte[] boardCnt = new byte[A_TO_Z];
            for (int i = 0; i < board.length(); i++)
                boardCnt[board.charAt(i)-'A']++;

            int[] result = new int[A_TO_Z];
            int min = WORD_LIMIT+1;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (!isValid(wordsCnt[i], boardCnt)) continue;

                for (int j = 0; j < A_TO_Z; j++) {
                    if (wordsCnt[i][j] != 0)
                        result[j]++;
                }
            }

            for (int j = 0; j < A_TO_Z; j++) {
                if (boardCnt[j] == 0) continue;
                if (min > result[j]) min = result[j];
                if (max < result[j]) max = result[j];
            }
            
            for (int j = 0; j < A_TO_Z; j++) {
                if (boardCnt[j] != 0 && result[j] == min)
                    answer.append((char)('A'+j));
            }
            answer.append(' ').append(min).append(' ');
            
            for (int j = 0; j < A_TO_Z; j++) {
                if (boardCnt[j] != 0 && result[j] == max)
                    answer.append((char)('A'+j));
            }
            answer.append(' ').append(max).append('\n');
        }
        System.out.print(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}