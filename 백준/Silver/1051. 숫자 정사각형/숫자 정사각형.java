import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int size = Math.min(N,M);
        boolean check = false;
        arr = new int[N][M];
        
        for(int i=0;i<N;i++){
            String info = br.readLine();
            for(int j=0;j<M;j++)
                arr[i][j] = Character.getNumericValue(info.charAt(j));
        }
        
        while(size != 1){
            for(int i=0;i<=N-size;i++){
                for(int j=0;j<=M-size;j++)
                    if(search(i, j, size-1)){
                        check = true;
                        break;
                    }
                
                if(check)
                    break;
            }
            
            if(check)
                break;
            size--;
        }
        
        int answer = size * size;
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
    
    static boolean search(int y, int x, int size){
        if(arr[y][x] == arr[y + size][x] && arr[y][x] == arr[y][x+size] &&
                arr[y][x] == arr[y+size][x+size])
            return true;
        return false;
    }
}