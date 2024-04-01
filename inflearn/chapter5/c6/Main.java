package inflearn.chapter5.c6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        whoIsResqueWangJa(N, K);

    }

    private static void whoIsResqueWangJa(int N, int K) {

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i ++) {
            q.add(i);
        }

        int cnt = 1;
        while(q.size() > 1) {

            if (cnt == K) {
                cnt = 1;
                q.poll();
            }

            else {
                q.add(q.poll());
                cnt++;
            }

        }

        System.out.println(q.poll());

    }


}
