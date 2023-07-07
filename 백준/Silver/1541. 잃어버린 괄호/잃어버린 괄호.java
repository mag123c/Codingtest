import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split("-");
        int[] arr = new int[strArr.length];

        int idx = 0;
        for(String s1 : strArr) {
            for(String split : s1.split("\\+")) {
                arr[idx] += Integer.parseInt(split);
            }
            idx++;
        }

        int answer = arr[0];
        for(int i = 1; i < arr.length; i ++) {
            answer -= arr[i];
        }
        System.out.println(answer);
    }
}