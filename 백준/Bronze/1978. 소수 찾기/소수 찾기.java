import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());
            if(number == 1) continue;
            boolean chk = false;

            for(int i = 2; i*i <= number; i++){
                if(number % i == 0) {
                    chk = true;
                    break;
                }
            }
            if(!chk) answer++;
        }
        System.out.println(answer);
    }
}
