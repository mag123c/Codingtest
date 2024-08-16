import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
 
    static int n, m;
    static int[][] arr;
    static int result = -1;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
 
        arr = new int[10][10];
 
        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s1.charAt(j)));
            }
        }
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                for (int mi = -n; mi < n; ++mi)
                    for (int mj = -m; mj < m; ++mj)
                    {
                        if (mi == 0 && mj == 0) {
                            continue;
                        }
 
                        int t = 0;
                        int newI = i;
                        int newJ = j;
                        while (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                            t = 10 * t + arr[newI][newJ]; 
                            if (Math.abs(Math.sqrt(t) - (int)Math.sqrt(t)) < 1e-10){
                                result = Math.max(result, t);
                            }
                            newI += mi;
                            newJ += mj;
                        }
 
                    }
        System.out.println(result);
    }
}