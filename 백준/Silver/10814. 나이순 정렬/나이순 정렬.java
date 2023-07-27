import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[201];

        for(int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());

            arr[idx] += st.nextToken() + " ";
        }


        StringBuffer sb = new StringBuffer();

        for(int i = 1; i < 201; i ++) {
            if(arr[i] != null) {
                String[] tmp = arr[i].trim().replace("null", "").split(" ");

                for(String str : tmp) sb.append(i + " " + str + "\n");
            }
        }
        System.out.println(sb);
    }
}
