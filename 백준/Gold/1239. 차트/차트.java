import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] chart;
    static boolean[] check;
    static int result = 0;
    static int N;
    static int fullMask;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int max  = -1;
        chart = new int[N];
        check = new boolean[51];
        fullMask = (1 << N) - 1;
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        
        for(int i=0;i<N;i++){
            chart[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, chart[i]);
        }
        if(max > 50) bw.write("0");
        else if(max == 0) bw.write("1");
        else{
            check[0] = true;
            search(0, 0,false, 0);
            bw.write(String.valueOf(result));
        }
        bw.flush();	
        bw.close();
        br.close();
    }
    
    static void search(int cnt, int sum, boolean flag, int mask){
        if(mask == fullMask){	
            result = Math.max(result, cnt);
            return;
        }

        for(int i=0;i<N;i++){
            if((mask & (1<<i)) >= 1)	
                continue;
            int temp = chart[i] + sum;

            if(!flag){	
                if(temp>= 50){	
                    if(check[temp % 50]) {
                        search(cnt+1, temp % 50, true, mask | (1 << i));
                    }
                    else {
                        search(cnt, temp%50, true, mask|(1<<i));
                    }
                }
                else{
                    check[temp] = true;	
                    search(cnt, temp, false, mask | (1<<i) );
                    check[temp] = false;
                }
            }
            else{
                if(check[temp]) {	
                    search(cnt + 1, temp, true, mask | (1 << i));
                }
                else {
                    search(cnt, temp, true, mask | (1<<i));
                }
            }
        }
    }
}
