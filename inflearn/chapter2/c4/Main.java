package inflearn.chapter2.c4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(m.pibonacchi(N));

    }

    private String pibonacchi(int N) {

        int[] pibo = new int[N];
        pibo[0] = 1;
        pibo[1] = 1;

        StringBuilder sb = new StringBuilder().append(pibo[0]).append(" ").append(pibo[1]).append(" ");

        for (int i = 2; i < pibo.length; i ++) {
            pibo[i] = pibo[i - 1] + pibo[i - 2];
            sb.append(pibo[i]).append(" ");
        }

        return sb.toString();
    }

}
