package inflearn.chapter2.c1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i ++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(m.biggerThanBeforeNum(arr));

    }

    private String biggerThanBeforeNum(int[] arr) {

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");


        for (int i = 1; i < arr.length; i ++) {
            if (arr[i - 1] < arr[i]) {
                sb.append(arr[i]).append(" ");
            }
        }

        return sb.toString();

    }

}
