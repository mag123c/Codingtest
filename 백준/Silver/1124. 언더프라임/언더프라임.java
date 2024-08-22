import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        boolean[] prime = new boolean[100001];
        int[] count = new int[100001];
        prime[0] = prime[1] = true;
        
        for(int i = 2; i < 100001; i++){
           if(prime[i]) continue;
            
           for(int j = i + i; j < 100001; j += i){
              prime[j] = true;
              int tmp = j;
               
              while(tmp % i == 0){
                 tmp /= i;
                 count[j]++;
              }
           }
        }
        
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
         
        int res = 0;
        for(int i = A; i <= B; i++){
           if(!prime[count[i]]) res++;
        }
         
        System.out.println(res);
    }
}
