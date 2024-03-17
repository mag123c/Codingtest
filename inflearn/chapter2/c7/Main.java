package inflearn.chapter2.c7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int answerCnt = 0;
        int answer = 0;

        for(int i = 0; i < N; i++) {
            int ox = sc.nextInt();

            if (ox == 1) {
                answerCnt++;
                answer += answerCnt;
            }

            if (ox == 0) {
                answerCnt = 0;
            }
        }

        System.out.println(answer);

    }


}
