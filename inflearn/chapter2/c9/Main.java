package inflearn.chapter2.c9;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(m.biggestSumBoard(board, N));

    }

    private int biggestSumBoard(int[][] board, int N) {

        int answer = 0;
        int daegak1 = 0;
        int daegak2 = 0;

        for (int i = 0; i < N; i ++) {
            int garo = 0;
            int sero = 0;

            for(int j = 0; j < N; j ++) {
                garo += board[i][j];
                sero += board[j][i];

                if (i == j) {
                    daegak1 += board[i][j];
                }
                if (i + j == N - 1) {
                    daegak2 += board[i][j];
                }
            }

            answer = Math.max(garo, answer);
            answer = Math.max(sero, answer);
        }


        return Math.max(Math.max(daegak1, daegak2), answer);


    }

}