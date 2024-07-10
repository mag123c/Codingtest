import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] box = {R, G, B};
        int answer = 0;

        for (int i = 0; i < 3; i ++) {
            answer += box[i] / 3;
            box[i] %= 3;
        }

        Arrays.sort(box);

        answer += box[0];
        box[1] -= box[0];
        box[2] -= box[0];

        while (box[1] > 0 && box[2] > 0) {
            answer++;
            box[1]--;
            box[2]--;
        }

        if (box[2] > 0) answer++;


        System.out.println(answer);
    }
}
