import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        backtracking(0, arr);

        print(String.valueOf(answer));

        bw.flush();
        bw.close();
    }

    private static void backtracking(int depth, int[] arr) {
        if (depth == arr.length) {
            answer++;
            return;
        }

        for (int i = 0; i < arr.length; i ++) {
            arr[depth] = i;

            if (isPut(depth, arr)) {
                backtracking(depth + 1, arr);
            }
        }
    }

    private static boolean isPut(int depth, int[] arr) {
        for (int i = 0; i < depth; i ++) {
            if (arr[depth] == arr[i]) return false;

            else if (Math.abs(arr[depth] - arr[i]) == Math.abs(depth - i)) return false;
        }

        return true;
    }

    private static void print(String value) throws IOException {
        bw.write(value);
    }
}
