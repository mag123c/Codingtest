import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static int money = 5 * (int) Math.pow(10, 6);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i ++) {
            ArrayList<Integer> list = new ArrayList<>();
            int L = 1;
            while(L > 0) {
                L = Integer.parseInt(br.readLine());
                list.add(L);
            }

            Collections.sort(list, Collections.reverseOrder());
            int answer = 0;
            int len = list.size();

            for (int j = 0; j < len; j ++) {
                answer += Math.pow(list.get(j), j + 1);
            }

            if (answer > money)
                System.out.println("Too expensive");
            else
                System.out.println(answer * 2);
        }
    }
}
