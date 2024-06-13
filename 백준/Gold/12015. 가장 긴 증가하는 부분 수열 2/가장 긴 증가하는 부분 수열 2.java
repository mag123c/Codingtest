import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int pos = bs(lis, arr[i]);

            if (pos < lis.size()) {
                lis.set(pos, arr[i]);
            } else {
                lis.add(arr[i]);
            }
        }

        System.out.println(lis.size());
    }

    private static int bs(ArrayList<Integer> lis, int number) {
        int start = 0;
        int end = lis.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (lis.get(mid) < number) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return start;
    }

}
