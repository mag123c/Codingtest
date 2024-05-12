import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[7];

        for (int i = 0; i < 3; i ++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int cnt = 0;
        int maxIdx = -1;
        int maxCnt = 0;
        for (int i = 6; i >= 0; i --) {
            if (arr[i] > 0) {
                if (maxCnt < arr[i]) {
                    maxCnt = arr[i];
                    maxIdx = i;
                }
                cnt++;
            }
        }

        if (cnt == 2) {
            print(String.valueOf(1000 + maxIdx * 100), bw);
        }
        else if (cnt == 1) {
            print(String.valueOf(10000 + maxIdx * 1000), bw);
        }
        else {
            print(String.valueOf(maxIdx * 100), bw);
        }

        bw.flush();
        bw.close();
    }

    public static void print(String tmp, BufferedWriter bw) throws IOException {
        bw.write(tmp);
    }
}