package inflearn.chapter4.c4;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String T = sc.nextLine();

        System.out.println(m.countPartOfAnagram(S, T));

    }

    private int countPartOfAnagram(String S, String T) {

        HashMap<String, Integer> origin = new HashMap<>();
        HashMap<String, Integer> compare = new HashMap<>();

        int Tlength = T.length();
        String[] split = S.split("");
        String[] tSplit = T.split("");

        for (int i = 0; i < Tlength; i ++) {
            origin.put(tSplit[i], origin.getOrDefault(tSplit[i], 0) + 1);

            if (i < Tlength - 1) {
                compare.put(split[i], compare.getOrDefault(split[i], 0) + 1);
            }
        }

        int answer = 0;
        for (int i = Tlength - 1; i < split.length; i ++) {
            compare.put(split[i], compare.getOrDefault(split[i], 0) + 1);

            if (origin.equals(compare)) answer ++;

            if (compare.get(split[i - Tlength + 1]) == 1) {
                compare.remove(split[i - Tlength + 1]);
            }
            else if (compare.get(split[i - Tlength + 1]) > 1){
                compare.put(split[i - Tlength + 1], compare.getOrDefault(split[i - Tlength + 1], 0) - 1);
            }
        }

        return answer;

    }


}
