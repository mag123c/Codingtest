package inflearn.chapter5.c5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String s = sc.next();

            countStick(s);

    }

    private static void countStick(String s) {

        int before = 0;
        int beforechk = 0;
        int cnt = 0;
        for (String tmp : s.split("")) {

            if (tmp.equals("(")) {
                if (beforechk == 1)  {
                    cnt++;
                    before ++;
                }
                beforechk = 1;
            }

            else if (tmp.equals(")")) {
                if (beforechk == 1) {
                    cnt += before;
                }

                else if (beforechk == 0) {
                    before = before > 0 ? before - 1 : 0;
                }
                beforechk = 0;
            }

        }

        System.out.println(cnt);

    }


}
