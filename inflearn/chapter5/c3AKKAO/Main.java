package inflearn.chapter5.c3AKKAO;

import java.util.Scanner;
import java.util.Stack;

/**
 * 카카오 인형뽑기문제 (2019 Winter Internship
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] board = new int[N][N];
        for (int i = 0 ; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                board[i][j] = sc.nextInt();
            }
        }

        int M = sc.nextInt();
        int[] moves = new int[M];
        for (int i = 0; i < M; i ++) {
            moves[i] = sc.nextInt();
        }

        countDisappearedDolls(N, M, board, moves);

    }

    private static void countDisappearedDolls(int N, int M, int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();

        //check[moves[i]]
        // moves[i] = 현재 옮겨야 할 보드의 x
        // check[i] = idx의 현재 깊이
        // check[moves[i]] x의 깊이
        // board[check[moves[i]]][moves[i]] - 구하고자하는 i번째 차례의 i번째 idx의 깊이의 인형값
        int answer = 0;
        for (int i = 0; i < M; i ++) {
            int current = 0;
            for (int j = 0; j < N; j ++) {
                if (board[j][moves[i] - 1] == 0) continue;
                current = board[j][moves[i] - 1];
                board[j][moves[i] - 1] = 0;
                break;
            }
            if (current == 0) continue;

            if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
                answer++;
            }

            else {
                stack.add(current);
            }
        }

        System.out.println(answer * 2);


    }


}
