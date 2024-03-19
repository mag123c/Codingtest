package inflearn.chapter2.c8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] score = new int[N];
        int[] rank = new int[N];

        for (int i = 0; i < N; i ++) {
            score[i] = sc.nextInt();
        }

        for (int i : m.calRankForScore(score, rank)) {
            System.out.print(i + " ");
        }


    }

    private int[] calRankForScore(int[] score, int[] rank) {

        for (int i = 0; i < score.length; i ++) {
            int idx = 1;

            for (int j = i - 1; j >= 0; j --) {
                if (score[i] < score[j]) {
                    idx ++;
                }
                else if (score[i] > score[j]) {
                    rank[j]++;
                }
            }
            rank[i] = idx;
        }

        return rank;

    }

}
