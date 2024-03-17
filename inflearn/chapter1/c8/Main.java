package inflearn.chapter1.c8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        String word = sc.nextLine();

        if (m.isValidPalindromeWord(word)) System.out.println("YES");
        else System.out.println("NO");

        return;

    }

    private boolean isValidPalindromeWord(String word) {

        word=word.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp=new StringBuilder(word).reverse().toString();

        return word.equals(tmp);

    }


}
