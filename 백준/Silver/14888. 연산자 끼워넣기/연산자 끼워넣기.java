import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i ++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int multiply = Integer.parseInt(st.nextToken());
        int divide = Integer.parseInt(st.nextToken());

        char[] sign = toCharArray(plus, minus, multiply, divide, N - 1);
        boolean[] isVisit = new boolean[N - 1];

        backtracking(number, sign, isVisit, number[0], 0, N);

        print(max + "\n");
        print(String.valueOf(min));

        bw.flush();
        bw.close();
    }

    private static void backtracking(int[] number, char[] sign, boolean[] isVisit, int cal, int cnt, int N) {
        if (cnt == N - 1) {
            max = Math.max(max, cal);
            min = Math.min(min, cal);
            return;
        }

        for (int i = 0; i < N - 1; i ++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                backtracking(number, sign, isVisit, calWithSign(sign[i], cal, number[cnt + 1]), cnt + 1, N);
                isVisit[i] = false;
            }
        }
    }

    private static int calWithSign(char sign, int num1, int num2) {
        switch (sign) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    private static char[] toCharArray(int p, int m, int mul, int d, int len) {
        char[] arr = new char[len];
        int idx = 0;
        while(true) {
            if (p > 0) {
                arr[idx] = '+';
                idx++;
                p--;
            }
            else if (m > 0) {
                arr[idx] = '-';
                idx++;
                m--;
            }
            else if (mul > 0) {
                arr[idx] = '*';
                idx++;
                mul--;
            }
            else if (d > 0) {
                arr[idx] = '/';
                idx++;
                d--;
            }
            else break;
        }
        return arr;
    }

    private static void print(String value) throws IOException {
        bw.write(value);
    }
}
