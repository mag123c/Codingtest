package inflearn.chapter2.c10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] mountain = new int[N + 2][N + 2];
        boolean[][] check = new boolean[N + 2][N + 2];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                mountain[i][j] = sc.nextInt();
                check[i][j] = true;
            }
        }

        System.out.println(m.countPeaks(N, mountain, check));

    }

    private int countPeaks(int N, int[][] mountain, boolean[][] check) {

        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (!check[i][j]) continue;
                int location = mountain[i][j];
                int left = mountain[i][j - 1];
                int right = mountain[i][j + 1];
                int top = mountain[i - 1][j];
                int bottom = mountain[i + 1][j];

                //left
                if (isLocationHigherThan(location, left)) {
                    check[i][j - 1] = false;
                    left = 0;
                }
                //right
                if (isLocationHigherThan(location, right)) {
                    check[i][j + 1] = false;
                    right = 0;
                }
                //top
                if (isLocationHigherThan(location, top)) {
                    check[i - 1][j] = false;
                    top = 0;
                }
                //bottom
                if (isLocationHigherThan(location, bottom)) {
                    check[i + 1][j] = false;
                    bottom = 0;
                }

                if (left == 0 && right == 0 && top == 0 && bottom == 0) {
                    count++;
                }

            }
        }
        return count;
    }

    private boolean isLocationHigherThan(int location, int tmp) {
        return location > tmp;
    }

}
