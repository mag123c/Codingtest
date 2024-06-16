import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i ++) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i ++) {
            int number = Integer.parseInt(st.nextToken());
            if (map.containsKey(number)) {
                map.remove(number);
            }
        }

        bw.write(map.size() + "\n");

        if (!map.isEmpty()) {
            int[] answer = map.keySet().stream().sorted().mapToInt(Integer::intValue).toArray();

            for (int i : answer) bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}
