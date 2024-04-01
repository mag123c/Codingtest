package inflearn.chapter5.c2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        notInBracketLetter(s);

    }

    private static void notInBracketLetter(String s) {

        StringBuilder sb = new StringBuilder();

        int bracketCnt = 0;
        for (String split : s.split("")) {
            if (split.equals("(")) bracketCnt++;
            else if (split.equals(")")) bracketCnt--;
            else if (bracketCnt == 0) sb.append(split);
        }

        System.out.println(sb.toString());

    }


}
