import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        int[] part1 = new int[N / 2];
        int[] part2 = new int[N - N / 2];

        for (int i = 0; i < N / 2; i++) {
            part1[i] = Integer.parseInt(line[i]);
        }
        for (int i = N / 2; i < N; i++) {
            part2[i - N / 2] = Integer.parseInt(line[i]);
        }

        ArrayList<Integer> parts1 = new ArrayList<>();
        ArrayList<Integer> parts2 = new ArrayList<>();
        dfs(0, part1, 0, parts1, C);
        dfs(0, part2, 0, parts2, C);

        Collections.sort(parts2);

        long result = 0;
        for (int a : parts1) {
            int remain = C - a;
            result += upperBound(parts2, remain);
        }

        System.out.println(result);
    }

    public static void dfs(int idx, int[] part, int sum, ArrayList<Integer> result, int C) {
        if (sum > C) return;
        if (idx == part.length) {
            result.add(sum);
            return;
        }

        dfs(idx + 1, part, sum, result, C);
        dfs(idx + 1, part, sum + part[idx], result, C);
    }

    public static int upperBound(ArrayList<Integer> list, int key) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
