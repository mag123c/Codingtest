import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        quickSort(arr, 0, arr.length - 1);

        print(arr, bw);

        bw.flush();
        bw.close();
    }

    public static void quickSort(int[] arr, int start, int end) {
        int partition = partition(arr, start, end);
        if (start < partition - 1) {
            quickSort(arr, start, partition - 1);
        }
        if (end > partition) {
            quickSort(arr, partition, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while(start <= end) {
            while(pivot > arr[start]) start++;
            while(pivot < arr[end]) end--;

            if (start<= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void print(int[] arr, BufferedWriter bw) throws IOException {
        for (int i: arr) {
            bw.write(Integer.toString(i) + "\n");
        }
    }

}
