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
        Map<String, String> sitePW = new HashMap<>();

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            String site = st.nextToken();
            String pw = st.nextToken();

            sitePW.put(site, pw);
        }

        for (int i = 0; i < M; i ++) {
            String findSite = br.readLine();

            if(sitePW.containsKey(findSite)) System.out.println(sitePW.get(findSite));
        }
    }
}
