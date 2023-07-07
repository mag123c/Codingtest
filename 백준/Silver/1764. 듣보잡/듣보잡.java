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
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N + M; i ++) {
            String person = br.readLine();
            map.put(person, map.getOrDefault(person, 0) + 1);
            if(map.get(person) > 1) list.add(person);
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(String s : list) System.out.println(s);

    }
}