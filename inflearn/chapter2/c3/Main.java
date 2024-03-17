import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < 2; i ++) {
            for (int j = 0; j < N; j++) {
                if (i == 0) {
                    A[j] = sc.nextInt();
                }
                else {
                    B[j] = sc.nextInt();
                }
            }
        }

        for (int i = 0; i < N; i ++) {
            System.out.println(m.winnerOfGame(A[i], B[i]));
        }

    }

    private String winnerOfGame(int a, int b) {

        if (a == 1) {
            return (b == 1) ? "D" : (b == 2) ? "B" : "A";
        }

        if (a == 2) {
            return (b == 1) ? "A" : (b == 2) ? "D" : "B";
        }

        if (a == 3) {
            return (b == 1) ? "B" : (b == 2) ? "A" : "D";
        }

        return null;

    }

}
