import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Stack<Integer> coin = new Stack<>();

        for(int i = 0; i < N; i ++) {
            coin.push(Integer.valueOf(br.readLine()));
        }
        int cnt = 0;
        while(K != 0) {
            int curCoin = coin.pop();
            if(curCoin > K) continue;

            int div = K / curCoin;
            cnt += div;
            K %= (curCoin * div);
        }
        System.out.println(cnt);
    }
}
