import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> entryMap = new HashMap<>();
        int overtimeCount = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("+")) {
                entryMap.put(name, entryMap.getOrDefault(name, 0) + 1);
            } else {
                if (entryMap.getOrDefault(name, 0) == 0) {
                    overtimeCount++;
                } else {
                    entryMap.put(name, entryMap.get(name) - 1);
                }
            }
        }

        for (int count : entryMap.values()) {
            overtimeCount += count;
        }

        System.out.println(overtimeCount);
    }
}
