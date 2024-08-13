import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        String line = br.readLine();
        int box = -1;
        int robot = -1;
        int goal = -1;
        for (int i = 0; i < 10; i ++) {
            if (line.charAt(i) == '@') {
                robot = i;
            }
            if (line.charAt(i) == '#') {
                box = i;
            }
            if (line.charAt(i) == '!') {
                goal = i;
            }
        }

        if (robot < goal) {
            if (goal < box || robot > box) {
                System.out.println(-1);
            }
            else {
                System.out.println(goal - box + box - robot - 1);
            }

        }

        else if (robot > goal) {
            if (goal > box || robot < box) {
                System.out.println(-1);
            }
            else {
                System.out.println(box - goal + robot - box - 1);
            }
        }
    }

}
