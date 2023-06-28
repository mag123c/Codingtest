import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i = 0; i < testcase; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[N];
            Queue<Integer> queue = new LinkedList<>();

            for(int j = 0; j < N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[j] = tmp;
                queue.add(j);
            }

            int cnt = 0;
            while(!queue.isEmpty()){
                boolean chk = false;
                int before = queue.poll();

                for(int j : arr){
                    if(arr[before] < j){
                        queue.add(before);
                        chk = true;
                        break;
                    }
                }

                if(!chk){
                    cnt++;
                    arr[before] = 0;
                    if(before == M){
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}
