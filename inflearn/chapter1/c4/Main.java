package inflearn.chapter1.c4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main instance = new Main();

        int N = sc.nextInt();

        for (int i = 0; i < N; i ++) {

            String word = sc.next();

            String answer = instance.wordToReverse(word);
            System.out.println(answer);

        }

    }

    private String wordToReverse(String word) {

        StringBuilder answer = new StringBuilder(word).reverse();

        return answer.toString();

    }

}
