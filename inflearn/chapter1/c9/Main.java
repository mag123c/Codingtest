package inflearn.chapter1.c9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        String word = sc.next();

        int answer = m.extractNumber(word);
        System.out.println(answer);

        return;

    }

    private int extractNumber(String word) {

        StringBuilder str = new StringBuilder();

        for (char c : word.toCharArray()) {

            if(Character.isDigit(c)) str.append(c);

        }

        return Integer.parseInt(str.toString());

    }

}
