package inflearn.chapter1.c7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        String word = sc.next();

        if (m.isValidPalindromeWord(word)) System.out.println("YES");
        else System.out.println("NO");

        return;

    }

    private boolean isValidPalindromeWord(String word) {

        char[] wordArr = word.toLowerCase().toCharArray();

        for (int i = 0; i < wordArr.length / 2; i ++) {

            if (wordArr[i] != wordArr[wordArr.length - 1 - i]) {

                return false;

            }

        }

        return true;

    }

}
