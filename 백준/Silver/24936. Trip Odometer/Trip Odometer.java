import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;

        for (int i = 0; i < N; i ++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            arr[i] = num;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i ++) {
            set.add(sum - arr[i]);
        }

        int size = set.size();
        bw.write(size+ "\n");

        int[] answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();

        for (int i : answer) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}
