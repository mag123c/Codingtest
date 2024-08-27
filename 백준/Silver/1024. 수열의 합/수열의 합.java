import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();	//n
        int l = sc.nextInt();	//l
        int t = 0;

        for(int i = 0; i < l; i++) {
            t += i;
        }

        while(true) {
            if((n - t) % l == 0 && (n - t) / l >= 0) {
                int div = (n - t) / l;	

                for(int i = 0; i < l; i++) {
                    System.out.printf("%d ", div + i);
                }
                return;
            }
            else {
                t += l;
                if(n - t < 0 || ++l > 100) {
                    System.out.println("-1");
                    return;
                }
            }
        }
    }
}