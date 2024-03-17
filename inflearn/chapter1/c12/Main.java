package inflearn.chapter1.c12;

import java.util.Scanner;

public class Main {

    // 1. 암호 -> 이진수
    // 2. 이진수 -> 십진수
    // 3. 십진수 -> 아스키코드
    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String word = sc.next();

        String answer = m.encodePassword(N, word);
        System.out.println(answer);

    }

    private String encodePassword(int N, String word) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i ++) {
            String part = partOfWord(i, word);
            int totalNum = 0;

            for (int j = 0; j < part.length(); j++) {
                if (part.charAt(j) == '#') {
                    totalNum += charToBinary(part.length() - 1 - j);
                }
            }

            sb.append(numberToAscii(totalNum));
        }

        return sb.toString();

    }

    private String partOfWord(int i, String word) {

        return word.substring((i * 7), (i + 1) * 7);

    }

    private int charToBinary(int number) {

        return (int) Math.pow(2, number);

    }

    private char numberToAscii(int number) {

        return (char) (number);

    }

}
