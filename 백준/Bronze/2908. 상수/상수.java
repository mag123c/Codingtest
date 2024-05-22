import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] arr1 = st.nextToken().toCharArray();
        char[] arr2 = st.nextToken().toCharArray();

        int a = 0;
        int b = 0;

        for (int i = 2; i>= 0; i--) {
            a += (int) (Integer.parseInt(String.valueOf(arr1[i])) * Math.pow(10, i));
            b += (int) (Integer.parseInt(String.valueOf(arr2[i])) * Math.pow(10, i));
        }

        System.out.println(Math.max(a, b));
    }
}