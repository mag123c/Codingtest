import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        int index = -1;
        String bitMask = Integer.toBinaryString(N);
        int tmp = Integer.bitCount(N);
        
        if(tmp > K){
            for (int i = 0; i < bitMask.length(); i++) {
                if (K == 0) {
                    index = i;
                    break;
                }
                if (bitMask.charAt(i) == '1')
                    K--;
            }
            String temp = bitMask.substring(index);
            int t = Integer.parseInt(temp, 2);
            if (t != 0)
                answer = (int) (Math.pow(2, bitMask.length() - index) - t);
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}