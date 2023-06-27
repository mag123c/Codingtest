import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] Narr = new int[N];
        int[] arr = new int[8001];
        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(br.readLine());
            Narr[i] = number;
            arr[number + 4000]++;
        }

        int sum = 0;
        for(int i : Narr){
            sum += i;
        }
        if(sum % N == 0) System.out.println(sum / N);
        else System.out.println(Math.round((double)(sum) / N));

        Arrays.sort(Narr);
        System.out.println(Narr[N / 2]);

        int many = 0;
        for(int i : arr){
            many = Math.max(i, many);
        }

        int cnt = 0;
        int num = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == many) {
                cnt++;
                num = i - 4000;
            }
            if(cnt == 2) {
                break;
            }
        }
        System.out.println(num);

        System.out.println(Narr[N - 1] - Narr[0]);

    }

}
