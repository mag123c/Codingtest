import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        arr[1] = 1; arr[2] = 1;

        for(int i = 3; i < arr.length; i ++) {
            arr[i] = arr[i - 3] + arr[i - 2];
        }

        for(int i = 0; i < T; i ++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N]);
        }

    }
}
