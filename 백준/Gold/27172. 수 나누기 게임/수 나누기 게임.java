import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int LEN = 1000001;

        int N = Integer.parseInt(br.readLine());
        int[] read = new int[N];
        int[] score = new int[LEN];
        boolean[] bl = new boolean[LEN];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            read[i] = Integer.parseInt(st.nextToken());
            bl[read[i]] = true;
        }

        for (int i : read) {
            for (int j = i * 2; j < LEN; j += i) {
                if (bl[j]) {
                    score[i]++;
                    score[j]--;
                }
            }
        }

        for (int i : read) {
            bw.write(score[i] + " ");
        }       
        
        bw.flush();
        bw.close();
    }
}
