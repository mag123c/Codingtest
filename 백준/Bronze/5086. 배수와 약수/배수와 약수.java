import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int check1;
        int check2;
        int a;
        int b;
        while(true) {
            st  = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;

            check1 = 0;
            check2 = 0;
            if (b % a == 0) check1++;
            if (a % b == 0) check2++;

            if (check1 == 1) {
                System.out.println("factor");
            }
            else if (check2 == 1) {
                System.out.println("multiple");
            }
            else System.out.println("neither");
        }
    }
}