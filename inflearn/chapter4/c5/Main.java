package inflearn.chapter4.c5;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i ++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findBiggestNumOfKNumber(N, K, arr));

    }

    private static int findBiggestNumOfKNumber(int N, int K, int[] arr) {

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j ++) {
                for (int k = j + 1; k < N; k ++) {
                    set.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        int cnt = 0;
        for (int i : set) {
            cnt++;
            if (cnt == K) return i;
        }

        return -1;

    }
}
