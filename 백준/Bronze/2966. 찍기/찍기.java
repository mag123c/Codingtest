import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String answer = br.readLine();

        String[] names = {"Adrian", "Bruno", "Goran"};
        String[] patterns = {"ABC", "BABC", "CCAABB"};
        int[] score = new int[3];

        for (int i = 0; i < N; i++) {
            char c = answer.charAt(i);
            for (int j = 0; j < 3; j++) {
                if (patterns[j].charAt(i % patterns[j].length()) == c) {
                    score[j]++;
                }
            }
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        System.out.println(maxScore);
        for (int i = 0; i < 3; i++) {
            if (score[i] == maxScore) {
                System.out.println(names[i]);
            }
        }
    }
}
