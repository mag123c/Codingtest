package inflearn.chapter3.c6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        int zeroCnt = 0;
        for (int i = 0; i < N; i ++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) zeroCnt++;
        }

        System.out.println(m.partNumber(N, K, arr, zeroCnt));

    }

    private int partNumber(int N, int K, int[] arr, int zeroCnt) {

        if (zeroCnt <= K) return N;

        int changeCnt = K;
        int answer = -1;
        int right = 0;

        for(int i = 0; i < N; i ++) {
            if (arr[i]==0) changeCnt--;

            while(changeCnt >= 0) {
                if (arr[right] == 0) changeCnt--;
                right++;
            }

            answer = Math.max(answer, right-i+1);
        }

        return answer;


    }


}
