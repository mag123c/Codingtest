import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> reverseMap = new HashMap<>();

        for(int i = 0; i < N; i ++) {
            String poketmon = br.readLine();
            map.put(poketmon, i + 1);
            reverseMap.put(i + 1, poketmon);
        }

        for(int i = 0; i < M; i ++) {
            String question = br.readLine();
            if(map.containsKey(question)) {
                System.out.println(map.get(question));
            }
            else if(reverseMap.containsKey(Integer.parseInt(question))) {
                System.out.println(reverseMap.get(Integer.parseInt(question)));
            }
        }
    }
}
