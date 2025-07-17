import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i ++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            // 1. 길이
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            // 2. 숫자 합
            int aSum = 0;
            int bSum = 0;
            for (char c : a.toCharArray()) {
                if (Character.isDigit(c)) {
                    aSum += c - '0';
                }
            }
            for (char c : b.toCharArray()) {
                if (Character.isDigit(c)) {
                    bSum += c - '0';
                }
            }
            if (aSum != bSum) {
                return aSum - bSum;
            }

            // 3. 사전 순
            return a.compareTo(b);
        });

        for (String s: arr) System.out.println(s);
    }
}

