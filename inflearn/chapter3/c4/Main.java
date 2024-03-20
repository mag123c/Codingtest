package inflearn.chapter3.c4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i ++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(m.biggestWindow(arr, M));

    }

    private int biggestWindow(int[] arr, int M) {

        int answer = 0;

        int left = 0;
        int right = 1;
        int add = arr[0];

        while(right < arr.length && left < arr.length) {
            if (add < M) {
                add += arr[right];
                right ++;
            }

            else if (add > M) {
                add -= arr[left];
                left ++;
            }

            else {
                add -= arr[left];
                answer ++;
                left ++;
            }

        }

        return add == M ? answer + 1 : answer;
    }

}
