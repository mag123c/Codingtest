package inflearn.chapter1.c10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        char letter = sc.next().charAt(0);
        Main m = new Main();

        String answer = m.leastDistanceWordToLetter(word, letter);
        System.out.println(answer);

        return;

    }

    private String leastDistanceWordToLetter(String word, char letter) {

        int[] arr = new int[word.length()];
        int length = 101;
        for (int i = 0; i < word.length(); i ++) {
            if (word.charAt(i) == letter) {
                length = 0;
                arr[i] = length;
            }
            else {
                arr[i] = length;
            }
            length++;
        }

        length = 101;
        for (int i = word.length() - 1; i >= 0; i --) {
            if (word.charAt(i) == letter) {
                length = 0;
                arr[i] = length;
            }
            else {
                arr[i] = Math.min(length, arr[i]);
            }
            length++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i: arr) {
            sb.append(i);
            sb.append(" ");
        }

        return sb.toString();
    }

}
