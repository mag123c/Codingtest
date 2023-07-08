import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sort = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < arr.length; i ++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = sort[i] = now;
        }
        Arrays.sort(sort);

        int idx = 0;
        for(int i : sort) {
            if(!map.containsKey(i)) {
                map.put(i, idx);
                idx++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i : arr) sb.append(map.get(i) + " ");
        System.out.println(sb);
    }
}