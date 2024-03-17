package inflearn.chapter1.c6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        String word = sc.next();
        String answer = m.deleteDuplicateLetter(word);

        System.out.println(answer);
        return;

    }

    private String deleteDuplicateLetter(String word) {

        StringBuilder sb = new StringBuilder();
        int[] alphabetIdx = new int[26];

        for (char c : word.toCharArray()) {

            int ascii = c - 97;
            if (alphabetIdx[ascii] == 0) {

                sb.append(c);

            }

            alphabetIdx[ascii] ++;

        }

        return sb.toString();

    }

}
