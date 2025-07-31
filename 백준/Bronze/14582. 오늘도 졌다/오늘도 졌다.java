import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stU = new StringTokenizer(br.readLine());
        StringTokenizer stS = new StringTokenizer(br.readLine());

        int[] u = new int[9];
        int[] s = new int[9];
        for (int i = 0; i < 9; i++) u[i] = Integer.parseInt(stU.nextToken());
        for (int i = 0; i < 9; i++) s[i] = Integer.parseInt(stS.nextToken());

        int total = 0;
        boolean everLead = false;

        for (int i = 0; i < 9; i++) {
            total += u[i];
            if (total > 0) everLead = true;
            total -= s[i];
        }

        System.out.println(everLead && total < 0 ? "Yes" : "No");
    }
}
