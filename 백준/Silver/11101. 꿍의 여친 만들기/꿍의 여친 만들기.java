import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(",");
            int len = arr.length;
            Map<String, Integer> charm = new HashMap<>();
            for (int j = 0; j < len; j++) {
                String[] split = arr[j].split(":");
                charm.put(split[0], Integer.parseInt(split[1]));
            }

            arr = br.readLine().split("\\|");
            len = arr.length;
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int j = 0; j < len; j++) {
                max = 0;
                for (String tmp : arr[j].split("&")) {
                    max = Math.max(max, charm.get(tmp));
                }
                min = Math.min(min, max);
            }

            System.out.println(min);
        }

    }
}
