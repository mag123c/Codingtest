import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
    	
        boolean[] isPrime = new boolean[M + 1]; 

        isPrime[0] = isPrime[1] = true; 

        for (int i = 2; i * i <= M; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= M; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    	
        StringBuffer sb = new StringBuffer();
        for(int i = N; i <= M; i++) {
            if(!isPrime[i]) sb.append(i + "\n");
        }
    	
        System.out.println(sb);
    }
}
