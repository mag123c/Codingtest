package inflearn.chapter1.c2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        Main instance = new Main();
        String answer = instance.reverseLowerUpper(word);
        System.out.println(answer);

        return;

    }

    private String reverseLowerUpper(String word) {

        StringBuilder sb = new StringBuilder();

        for (char letter : word.toCharArray()) {

            if (letter >= 65 && letter <= 90) {
                sb.append((char) (letter + 32));
            }

            else sb.append((char) (letter - 32));

        }

        return sb.toString();

    }

}
