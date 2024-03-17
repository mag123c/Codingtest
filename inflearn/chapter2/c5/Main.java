package inflearn.chapter2.c5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(m.countSieveOfEra(N));

    }

    private int countSieveOfEra(int N) {

        boolean[] arr = new boolean[N + 1];
        int answer = 0;

        for (int i = 2; i <= N; i ++) {
            if (!arr[i]) {
                answer++;
                for (int j = i*i; j <= N; j += i) {
                    arr[j] = true;
                }
            }
        }

        return answer;

    }

}
