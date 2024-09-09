import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static List<Long> list = new ArrayList<>();

    public static void comb(long number) {
        list.add(number);
        long val = number % 10;
        if (val == 0) {
            return;
        }

        for (long i = val - 1; i >= 0; i--) {
            long temp = number * 10 + i;
            comb(temp);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        if (n <= 10) {
            System.out.println(n);
            return;
        } else if (n >= 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            comb(i);
        }

        Collections.sort(list);
        System.out.println(list.get(n));
    }
}