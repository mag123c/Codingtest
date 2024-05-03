import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int line = 1;
        int cnt = 1;
        while (true) {
            if (cnt >= N) break;

            line++;
            cnt += line;
        }

        int tmp = cnt - N;
        int top = 1 + tmp;
        int bottom = line  - tmp;

        if (line % 2 == 1) {
            System.out.println(top + "/" + bottom);
        }
        else {
            System.out.println(bottom + "/" + top);
        }

    }


}
