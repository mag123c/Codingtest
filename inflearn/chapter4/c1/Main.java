package inflearn.chapter4.c1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String str = sc.next();

        System.out.println(m.whoIs(N, str));

    }

    private String whoIs(int N, String str) {

        String who = "";
        String[] split = str.split("");
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : split) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int vote = 0;
        for (String s : map.keySet()) {
            int tmp = map.get(s);
            if (tmp > vote) {
                vote = tmp;
                who = s;
            }
        }

        return who;

    }


}
