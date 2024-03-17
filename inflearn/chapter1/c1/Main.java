package inflearn.chapter1.c1;

import java.util.Scanner;
//1-1 문자찾기
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String letter = sc.nextLine();

        int answer = countLetterInWord(word, letter);

        System.out.println(answer);
        return ;
    }

    private static int countLetterInWord(String word, String letter) {

        String wordToLowerCase = word.toLowerCase();
        String letterToLowerCase = letter.toLowerCase();

        int cnt = 0;

        for (int i = 0; i < wordToLowerCase.length(); i ++) {

            if (wordToLowerCase.charAt(i) == letterToLowerCase.charAt(0)) {

                cnt++;

            }

        }

        return cnt;

    }

}
