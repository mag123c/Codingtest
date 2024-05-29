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

        long money = 0;
        int minPrice = city[0];

        for (int i = 0; i < N - 1; i++) {
            if (city[i] < minPrice) {
                minPrice = city[i];
            }
            money += (long) minPrice * length[i];
        }

        System.out.println(money);
    }
}