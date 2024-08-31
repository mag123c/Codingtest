import java.util.Scanner;

class Main {
    static int[] num;
    private static int N;
    private static int S;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        dfs(0, 0);
        if (S == 0) System.out.println(answer - 1); 
         else  System.out.println(answer);

    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) answer++;
            return;
        }
        dfs(depth + 1, sum + num[depth]);
        dfs(depth + 1, sum); 
    }
}