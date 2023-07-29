import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[20000001];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i ++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[tmp + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < M; i ++) {
            int tmp = Integer.parseInt(st.nextToken());
            sb.append(arr[tmp + 10000000] + " ");
        }

        System.out.println(sb);

    }
}
