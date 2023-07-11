import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i ++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> clothes = new HashMap<>();
            for(int j = 0; j < n; j ++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String type = st.nextToken();

                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int day = 1;
            for(int j : clothes.values()) {
                day *= (j + 1);
            }
            System.out.println(day - 1);
        }

    }
}
