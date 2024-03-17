package inflearn.chapter1.c11;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        Main m = new Main();

        String answer = m.dupToNum(word);
        System.out.println(answer);

        return;

    }

    private String dupToNum(String word) {

        StringBuilder sb = new StringBuilder();
        char before = word.charAt(0);
        int cnt = 0;

        for (int i = 0; i < word.length(); i ++) {
            if (before == word.charAt(i)) {
                cnt++;
            }
            else {
                sb.append(before).append(cnt);
                before = word.charAt(i);
                cnt = 1;
            }
        }

        sb.append(before).append(cnt);

        return sb.toString().replaceAll("1", "");
    }

}
