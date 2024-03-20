package inflearn.chapter3.c5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(m.biggestContinuousNumAdded(N));

    }

    private int biggestContinuousNumAdded(int N) {


        int left = 1;
        int right = 2;
        int added = left;
        int cnt = 0;

        while(left <= N && right <= N) {
            if (left > N / 2 && right > N / 2) break;

            else if (added < N) {
                added += right;
                right++;
            }

            else if (added > N) {
                added -= left;
                left++;
            }

            else {
                added -= left;
                left++;
                cnt++;
            }
        }

        return cnt;

    }


}
