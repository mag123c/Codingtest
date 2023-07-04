import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[N][M];
        boolean[][] bl = new boolean[N][M];
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                tomato[i][j] = number;

                if(number == 1) {
                    queue.add(new int[] {i, j});
                }
            }

        }

        int day = queue.isEmpty() ? -1 : 0;
        int[] tmp1 = new int[] {1, -1, 0, 0};
        int[] tmp2 = new int[] {0, 0, 1, -1};

        while(!queue.isEmpty()) {
            int size = queue.size();
            int cnt = 0;

            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                int y = tmp[0];
                int x = tmp[1];

                for (int j = 0; j < 4; j++) {
                    int yy = y + tmp1[j];
                    int xx = x + tmp2[j];

                    if (xx >= 0 && xx < M && yy >= 0 && yy < N && !bl[yy][xx] && tomato[yy][xx] == 0) {
                        queue.add(new int[]{yy, xx});
                        tomato[yy][xx] = 1;
                        cnt++;
                    }
                }
            }

            if (cnt == 0) {
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < M; j++) {
                        if(tomato[i][j] == 0) {
                            System.out.println(-1);
                            return;
                        }
                    }
                }
                System.out.println(day);
                return;
            }

            day++;
        }

        System.out.println(day);
    }

}
