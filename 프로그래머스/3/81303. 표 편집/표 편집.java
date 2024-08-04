import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        int size = cmd.length;
        int nLen = n;
        Stack<Integer> rollback = new Stack<>();
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(cmd[i]);
            String command = st.nextToken();

            if (command.equals("D")) {
                int target = Integer.parseInt(st.nextToken());
                k += target;
            } else if (command.equals("U")) {
                int target = Integer.parseInt(st.nextToken());
                k -= target;
            } else if (command.equals("C")) {
                rollback.add(k);
                nLen--;
                if (k == nLen) {
                    k--;
                }
            } else {
                int back = rollback.pop();
                if (back <= k) {
                    k++;
                }
                nLen++;
            }
        }

        for (int i = 0; i < nLen; i++) {
            answer.append("O");
        }
        while (!rollback.isEmpty()) {
            answer.insert(rollback.pop().intValue(), "X");
        }
        return answer.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 8;
        int k = 2;
        String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };

        s.solution(n, k, cmd);
    }
}
