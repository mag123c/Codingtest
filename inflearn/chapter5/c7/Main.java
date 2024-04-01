package inflearn.chapter5.c7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String necessary = scanner.next();
        String whole = scanner.next();

        sulGye(necessary, whole);

    }

    private static void sulGye(String n, String w) {

        Queue<String> queue = new LinkedList<>();

        for (String nn: n.split("")) queue.offer(nn);

        for (String ww: w.split("")) {

            if (queue.isEmpty()) {
                System.out.println("YES");
                return;
            }

            else if (queue.contains(ww) && !queue.poll().equals(ww)) {
                System.out.println("NO");
                return;
            }

        }

        if (!queue.isEmpty()) System.out.println("NO");
        else System.out.println("YES");

    }

}
