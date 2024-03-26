package inflearn.chapter4.c3;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(m.totalSellPrice(N, K, arr));


    }

    private String totalSellPrice(int N, int K, int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < K; i++) {
            vauleSet(map, arr[i]);
        }

        StringBuilder sb = new StringBuilder().append(map.size()).append(" ");

        for (int i = K; i < N; i++) {
            int value = map.get(arr[i - K]);

            valueMinusSet(map, arr[i - K], value);

            vauleSet(map, arr[i]);

            sb.append(map.size()).append(" ");
        }

        return sb.toString();

    }

    private void vauleSet(HashMap<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    private void valueMinusSet(HashMap<Integer, Integer> map, int key, int value) {
        map.put(key, value - 1);

        if (map.get(key) == 0) map.remove(key);
    }


}
