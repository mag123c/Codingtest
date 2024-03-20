package inflearn.chapter3.c3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i ++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(m.bestSalesPerDay(arr, K));

    }

    private int bestSalesPerDay(int[] arr, int day) {

        int window = 0;
        for (int i = 0; i < day; i ++) {
            window += arr[i];
        }

        int answer = window;

        for (int i = day; i < arr.length; i ++) {
            window = window - arr[i - day] + arr[i];
            answer = Math.max(answer, window);
        }

        return answer;

    }


}
