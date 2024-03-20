package inflearn.chapter3.c1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nArr = new int[N];
        for (int i = 0; i < N; i ++) {
             nArr[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] mArr = new int[M];
        for (int i = 0; i < M; i ++) {
            mArr[i] = sc.nextInt();
        }

        for(int i : m.sortAsc(nArr, mArr)) {
            System.out.print(i + " ");
        }

    }

    private int[] sortAsc(int[] nArr, int[] mArr) {
        int[] arr = new int[nArr.length + mArr.length];

        int nIdx = 0;
        int mIdx = 0;
        int arrIdx = 0;
        while(arrIdx < arr.length) {

            if (nIdx >= nArr.length) {
                arr[arrIdx] = mArr[mIdx];
                mIdx++;
            }
            else if (mIdx >= mArr.length) {
                arr[arrIdx] = nArr[nIdx];
                nIdx++;
            }
            else if (nArr[nIdx] < mArr[mIdx]) {
                arr[arrIdx] = nArr[nIdx];
                nIdx++;
            }
            else {
                arr[arrIdx] = mArr[mIdx];
                mIdx++;
            }

            arrIdx++;

        }

        return arr;
    }


}
