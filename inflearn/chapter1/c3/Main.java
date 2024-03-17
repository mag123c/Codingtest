package inflearn.chapter1.c3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        Main instance = new Main();
        String answer = instance.findLongestWordInSentence(sentence);

        System.out.println(answer);
        return;

    }

    private String findLongestWordInSentence(String sentence) {

        String[] wordArr = sentence.split(" ");
        int beforeLen = wordArr[0].length();
        int longestIdx = 0;

        for (int i = 1; i < wordArr.length; i ++) {

            int wordLength = wordArr[i].length();

            if (beforeLen < wordLength) {

                longestIdx = i;
                beforeLen = wordLength;

            }

        }

        return wordArr[longestIdx];

    }

}
