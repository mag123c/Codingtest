import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int H;
    private static int[][][] tomato;
    private static boolean[][][] isVisit;
    private static int[] dn = {-1, 1, 0, 0, 0, 0};
    private static int[] dm = {0, 0, -1, 1, 0, 0};
    private static int[] dh = {0, 0, 0, 0, -1, 1};
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();

        tomato = new int[H][M][N];
        isVisit = new boolean[H][M][N];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1 && !isVisit[i][j][k]) {
                        queue.offer(new int[]{i, j, k});
                        isVisit[i][j][k] = true;
                    }
                }
            }
        }
        System.out.println(bfs(queue));
    }

    private static int bfs(Queue<int[]> queue) {
        int day = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            day++;

            for (int i = 0; i < size; i ++) {
                int[] tmp = queue.poll();

                for (int j = 0; j < 6; j ++) {
                    int newH = tmp[0] + dn[j];
                    int newM = tmp[1] + dm[j];
                    int newN = tmp[2] + dh[j];

                    if (validate(newH, newM, newN) && !isVisit[newH][newM][newN] && tomato[newH][newM][newN] == 0) {
                        isVisit[newH][newM][newN] = true;
                        tomato[newH][newM][newN] = 1;
                        queue.offer(new int[]{newH, newM, newN});
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (tomato[i][j][k] == 0) return -1;
                }
            }
        }

        return day;
    }

    private static boolean validate(int h, int m, int n) {
        return n >= 0 && m >= 0 && h >= 0 && n < N && m < M && h < H;
    }

}