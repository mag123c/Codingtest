package inflearn.chapter2.c11;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] grade = new int[N][5];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j ++) {
                grade[i][j] = sc.nextInt();
            }
        }

        int answer = -1;
        int tmp = 0;
        //selectMan
        for (int i = 0; i < N; i ++) {
            int cnt = 0;
            //tagerMan
            for (int j = 0; j < N; j ++) {
                //grade
                for (int k = 0; k < 5; k ++) {
                    if (grade[i][k] == grade[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > tmp) {
                tmp = cnt;
                answer = i + 1;
            }
        }

        System.out.println(answer);

    }

}
