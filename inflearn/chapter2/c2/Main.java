package inflearn.chapter2.c2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i ++) {
            arr[i] = sc.nextInt();
        }

        int answer = m.countVisibleStudent(arr);
        System.out.println(answer);

    }

    private int countVisibleStudent(int[] arr) {

        int min = 0;
        int cnt = 0;

        for (int i : arr) {
            if (min < i) {
                cnt ++;
                min = i;
            }
        }

        return cnt;

    }

}
