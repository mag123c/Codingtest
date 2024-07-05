import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int len = Integer.parseInt(br.readLine());

        long[] arr = new long[len];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < len; i++) {
            arr[i] = (long) (Integer.parseInt(st.nextToken()) * Math.pow(A, len - i - 1));
        }

        long sum = 0;
        for (long i : arr) {
            sum += i;
        }

        List<Long> list = new ArrayList<>();
        while (sum > 0) {
            list.add(sum % B);
            sum /= B;            
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + " ");
        }
        bw.flush();
        bw.close();
    }
}
