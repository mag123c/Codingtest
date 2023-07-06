import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            if(N > 32) {
                System.out.println(0);
                continue;
            }

            String[] MBTI = new String[N];

            for(int j = 0; j < N; j++) {
                MBTI[j] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;

            for(int j = 0; j < N; j++) {
                for(int k = j+1; k < N; k++) {
                    for(int l = k+1; l < N; l++) {
                        int cnt = 0;
                        for(int m = 0; m < 4; m++) {
                            cnt += MBTI[j].charAt(m) != MBTI[k].charAt(m) ? 1 : 0;
                            cnt += MBTI[j].charAt(m) != MBTI[l].charAt(m) ? 1 : 0;
                            cnt += MBTI[k].charAt(m) != MBTI[l].charAt(m) ? 1 : 0;
                        }
                        min = Math.min(cnt, min);
                        if(min == 0) break;
                    }
                }
            }
            System.out.println(min);
        }
    }
}
