import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int where = (int) Math.pow(2 ,N);

        findWhere(where, r, c);
        System.out.println(cnt);
    }

    private static void findWhere(int where, int r, int c) {
        if(where == 1) return;

        if(r < where/2 && c < where/2) {
            findWhere(where/2, r, c);
        }
        else if(r < where/2 && c >= where/2) {
            cnt += where * where / 4;
            findWhere(where/2, r, c - where/2);
        }
        else if(r >= where/2 && c < where/2) {
            cnt += (where * where / 4) * 2;
            findWhere(where/2, r - where/2, c);
        }
        else {
            cnt += (where * where / 4) * 3;
            findWhere(where/2, r - where/2, c - where/2);
        }
    }

}
