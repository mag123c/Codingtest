import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i ++) {
            int test = sc.nextInt();

            System.out.print("Case #" + (i + 1) + ": ");
            int result = blitrics(test);
            System.out.println(result == 0 ? "INSOMNIA" : result);
        }
    }

    private static int blitrics(int test) {
        if (test == 0) {
            return test;
        }

        Set<Character> set = new HashSet<>();
        
        int idx = 1;
        while(true) {
            String value = String.valueOf(test * idx);

            for (int i = 0; i < value.length(); i ++) {
                set.add(value.charAt(i));
            }

            if (set.size() < 10) {
                idx++;
            }
            else break;
        }

        return test * idx;
    }
}
