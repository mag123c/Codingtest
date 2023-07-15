import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        arr[0] = 0; arr[1] = 1;
        for (int i = 2; i < arr.length; i ++) {
            int min = 50001;
            for (int j = 1; j * j <= i; j ++) {
                int idx = i - j * j;
                min = Math.min(min, arr[idx]);
            }
            arr[i] = min + 1;
        }

        System.out.println(arr[arr.length - 1]);

    }
}
