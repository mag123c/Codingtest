import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] tmp = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine());
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            tmp[2] = Integer.parseInt(st.nextToken());

            if (tmp[0] == 0 && tmp[1] == 0 && tmp[2] == 0) break;

            isTrue(tmp);

        }

        bw.flush();
        bw.close();
    }

    private static void isTrue(int[] tmp) throws IOException {
        Arrays.sort(tmp);

        if (Math.pow(tmp[2], 2) == (Math.pow(tmp[0], 2) + Math.pow(tmp[1], 2))) {
            bw.write("right"+"\n");
        }
        else bw.write("wrong"+"\n");
    }


}
