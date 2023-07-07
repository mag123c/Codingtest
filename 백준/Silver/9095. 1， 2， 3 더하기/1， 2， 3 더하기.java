import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        //점화식
        for(int i = 4; i < arr.length; i ++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        for(int i = 0; i < T; i ++) {
            int test = Integer.parseInt(br.readLine());
            System.out.println(arr[test]);
        }
    }
}