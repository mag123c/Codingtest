import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] factorial = new int[N + 1];
        factorial[0] = 0;
        factorial[1] = 1;

        int tmp = 0;
        for(int i = 2; i <= N; i ++) {
            factorial[i] = factorial[i - 1] * i;
            if(factorial[i] > N) {
                tmp = i;
                break;
            }
        }

        int cnt = 0;
        for(int i = tmp; i >= 1; i --) {
            int div = 0;
            if(N / factorial[i] > 0) {
                div = N / factorial[i];
                N %= factorial[i];
                cnt += div;
            }

            if(N == 0) {
                System.out.println(cnt);
                return;
            }
        }
    }

}
