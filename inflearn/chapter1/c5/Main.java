package inflearn.chapter1.c5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        String word = sc.next();

        String reverseWord = m.reverseWord(word);
        System.out.println(reverseWord);

        return;

    }

    private String reverseWord(String word) {

        char[] charArr = word.toCharArray();

        int left = 0;
        int right = charArr.length - 1;

        while(left < right) {

            boolean leftTf = Character.isAlphabetic(charArr[left]);
            boolean rightTf = Character.isAlphabetic(charArr[right]);

            if (!leftTf) left++;
            if (!rightTf) right--;

            if (leftTf && rightTf) {

                char rightChar = charArr[right];
                charArr[right] = charArr[left];
                charArr[left] = rightChar;

                left++;
                right--;

            }

        }

        StringBuilder answer = new StringBuilder();
        for (char c : charArr) {

            answer.append(c);

        }

        return answer.toString();

    }

}
