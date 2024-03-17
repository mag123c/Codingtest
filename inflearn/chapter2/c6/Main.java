package inflearn.chapter2.c6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();

            int reverseNum = m.getReverseNum(number);
            if (reverseNum == 1) continue;

            if (m.isDecimal(reverseNum)) {
                sb.append(reverseNum).append(" ");
            }
        }

        System.out.println(sb.toString());

    }

    private int getReverseNum(int number) {
        int rev = 0;
        int rem;

        while (number > 0) {
            rem = number % 10;
            rev = (rev * 10) + rem;
            number = number / 10;
        }

        return rev;
    }

    private boolean isDecimal(int number) {

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number != i && number % i == 0) {
                return false;
            }
        }

        return true;

    }

}
