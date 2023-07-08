import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[] low = new int[N + 1];

        for(int i = 1; i < N + 1; i ++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        low[1] = stairs[1];
        if(N >= 2) {
            low[2] = stairs[1] + stairs[2];
        }

        for(int i = 3; i < N + 1; i ++) {
            low[i] = Math.max(low[i - 2], low[i - 3] + stairs[i - 1]) + stairs[i];
        }
        System.out.println(low[N]);
    }
}