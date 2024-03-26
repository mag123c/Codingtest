package inflearn.chapter4.c2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        String word1 = sc.next();
        String word2 = sc.next();

        System.out.println(main.isAnagram(word1, word2));

    }

    private String isAnagram(String word1, String word2) {

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(String w1 : word1.split("")) {
            map1.put(w1, map1.getOrDefault(w1, 0) + 1);
        }
        for(String w2 : word2.split("")) {
            map2.put(w2, map2.getOrDefault(w2, 0) + 1);
        }

        for(String key: map1.keySet()) {
            if (map1.get(key) != map2.get(key)) return "NO";
        }

        return "YES";

    }


}
