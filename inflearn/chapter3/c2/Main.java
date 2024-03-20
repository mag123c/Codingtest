package inflearn.chapter3.c2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] mArr = new int[M];
        for (int i = 0; i < M; i++) {
            mArr[i] = sc.nextInt();
        }

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        for (int i : m.findIntersection(nArr, mArr)) {
            System.out.print(i + " ");
        }

    }

    private ArrayList<Integer> findIntersection(int[] nArr, int[] mArr) {

        ArrayList<Integer> list = new ArrayList<>();
        int nIdx = 0;
        int mIdx = 0;

        while (nIdx < nArr.length && mIdx < mArr.length) {

            if (nArr[nIdx] > mArr[mIdx]) {
                mIdx++;
            }
            else if (nArr[nIdx] < mArr[mIdx]) {
                nIdx++;
            }
            else {
                list.add(nArr[nIdx]);
                nIdx++;
                mIdx++;
            }

        }

        return list;

    }


}
