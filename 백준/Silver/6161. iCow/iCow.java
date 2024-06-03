import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        iCow(arr, N, T);
    }

    private static void iCow(int[] arr, int N, int T) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < T; i++) {
            int idx = findBiggest(arr, N);
            bw.write((idx + 1) + "\n");
            provide(arr, N, idx);
        }

        bw.flush();
        bw.close();
    }

    private static int findBiggest(int[] arr, int N) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] > max || (arr[i] == max && idx > i)) {
                idx = i;
                max = arr[i];
            }
        }
        return idx;
    }

    private static void provide(int[] arr, int N, int idx) {
        int tmp = arr[idx];
        int div = tmp / (N - 1);
        int rem = tmp % (N - 1);

        for (int i = 0; i < N; i++) {
            if (i != idx) {
                arr[i] += div;
            }
        }

        for (int i = 0, added = 0; added < rem; i++) {
            if (i != idx) {
                arr[i] += 1;
                added++;
            }
        }

        arr[idx] = 0;
    }
}
