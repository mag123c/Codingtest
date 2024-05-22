import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] bucket = new int[N + 1];
        for (int i = 0; i < bucket.length; i ++) {
            bucket[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            reverse(start, end, bucket);
        }

        for(int i = 1; i < bucket.length; i ++) {
            System.out.print(bucket[i] + " ");
        }
    }

    private static void reverse(int start, int end, int[] bucket) {
        while(start < end) {
            int tmp = bucket[start];
            bucket[start] = bucket[end];
            bucket[end] = tmp;

            start++;
            end--;
        }
    }
}
