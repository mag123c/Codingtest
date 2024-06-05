import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fruits = new int[N];
        for (int i = 0; i < N; i ++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer(fruits, N);
    }

    private static void twoPointer(int[] fruits, int N) {
        int start = 0, end = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (end < N) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }

        System.out.println(max);
    }

}
