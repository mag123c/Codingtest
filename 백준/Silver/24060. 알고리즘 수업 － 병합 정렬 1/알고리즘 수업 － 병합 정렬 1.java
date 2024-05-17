import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int K;
    static int calls = 0;
    static int save = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] A = new int[size];
        int[] tmp = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i ++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(A, tmp, 0, size - 1);
        print(save);

        bw.flush();
        bw.close();
    }

    private static void mergeSort(int[] A, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(A, tmp, start, mid);
            mergeSort(A, tmp, mid + 1, end);
            merge(A, tmp, start, mid, end);
        }
    }

    private static void merge(int[] A, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = A[i];
        }

        int leftStart = start;
        int rightStart = mid + 1;
        int idx = start;

        while(leftStart <= mid && rightStart <= end) {
            if (tmp[leftStart] <= tmp[rightStart]) {
                A[idx] = tmp[leftStart];
                leftStart++;
            }
            else {
                A[idx] = tmp[rightStart];
                rightStart++;
            }
            checkAnswer(A[idx]);
            idx++;
        }

        while (leftStart <= mid) {
            A[idx] = tmp[leftStart];
            checkAnswer(A[idx]);
            leftStart++;
            idx++;
        }

        while (rightStart <= end) {
            A[idx] = tmp[rightStart];
            checkAnswer(A[idx]);
            rightStart++;
            idx++;
        }
    }

    private static void checkAnswer(int target) {
        calls++;
        if (calls == K) {
            save = target;
        }
    }

    private static void print(Object o) throws IOException {
        bw.write(String.valueOf(o));
    }
}