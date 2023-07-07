import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr= new int[N + 1];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine(), " ");

        int idx = 1;
        while(st.hasMoreTokens()) {
            arr[idx] = arr[idx - 1] + Integer.parseInt(st.nextToken());
            idx++;
        }

        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            System.out.println(arr[after] - arr[before - 1]);
        }
    }
}