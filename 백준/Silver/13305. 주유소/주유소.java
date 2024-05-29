import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] length = new int[N - 1];
        int[] city = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i ++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        int money = 0;

        for (int i = 0; i < N - 1; i ++) {
            boolean isExpensive = false;
            for (int j = i + 1; j < N - 1; j ++) {
                if (city[i] > city[j]) {
                    money += (city[i] * length[i]);
                    isExpensive = true;
                    break;
                }
            }

            if (!isExpensive) {
                for (int j = i; j < N - 1; j ++) {
                    money += (city[i] * length[j]);
                }
                System.out.println(money);
                return;
            }
        }

        System.out.println(money);
    }
}