package inflearn.chapter2.c12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] score = new int[M][N];

        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j ++) {
                score[i][j] = sc.nextInt();
            }
        }

        System.out.println(m.countAvailableMento(N, M, score));


    }

    private int countAvailableMento(int N, int M, int[][] score) {

        boolean[][] check = new boolean[N][N];
        for (int i = 0; i < M; i ++) {
            for (int j = 0 ; j < N; j ++) {
                for (int k = j + 1; k < N; k ++) {
                    int before = score[i][j];
                    int after = score[i][k];
                    check[before - 1][after - 1] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (check[i][j] ^ check[j][i]) {
                    cnt++;
                }
            }
        }
        return cnt / 2;

    }

}
