import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] arr = new int[10];
        for (int i = 2; i <= 9; i ++) {
            if (i == 7 || i == 9) {
                arr[i] = 4;
            }
            else arr[i] = 3;
        }

        int answer = 0;
        for (char c : word.toCharArray()) {
            char start = 'A' - 1;
            for (int i = 2; i <= 9; i ++) {
                start += arr[i];

                if (c <= start) {
                    answer += 2 + (i - 1);
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}