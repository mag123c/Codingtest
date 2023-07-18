import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] xArr = {-1, 1, 0, 0};
    static int[] yArr = {0, 0, -1, 1};
    static char[][] RGB;
    static char[][] RGB2;
    static boolean[][] visited;
    static int[] RGBCheck = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        RGB = new char[N][N];
        RGB2 = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i ++) {
            String color = br.readLine();
            for (int j = 0; j < N; j ++) {
                RGB[i][j] = color.charAt(j);

                if(color.charAt(j) == 'G') {
                    RGB2[i][j] = 'R';
                }
                else RGB2[i][j] = color.charAt(j);
            }
        }

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if(!visited[i][j]) bfs(RGB[i][j], i, j, "RGB");
            }
        }

        int answer1 = RGBCheck[0] + RGBCheck[1] + RGBCheck[2];
        RGBCheck = new int[3];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if(!visited[i][j]) bfs(RGB2[i][j], i, j, "RGB2");
            }
        }

        int answer2 = RGBCheck[0] + RGBCheck[1] + RGBCheck[2];
        System.out.println(answer1 + " " + answer2);

    }

    private static void bfs(char color, int y, int x, String tmp) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i ++) {
                int[] current = queue.poll();
                x = current[1];
                y = current[0];

                for (int j = 0; j < 4; j ++) {
                    int newX = x + xArr[j];
                    int newY = y + yArr[j];

                    if(newY < 0 || newY >= N || newX < 0 || newX >= N || visited[newY][newX]) continue;
                    if(tmp.equals("RGB")) {
                        if(RGB[newY][newX] == RGB[y][x]) {
                            queue.add(new int[]{newY, newX});
                            visited[newY][newX] = true;
                        }
                    }
                    else {
                        if(RGB2[newY][newX] == RGB2[y][x]) {
                            queue.add(new int[]{newY, newX});
                            visited[newY][newX] = true;
                        }
                    }
                }
            }
        }
        switch(color) {
            case 'R': RGBCheck[0]++;
                break;
            case 'G': RGBCheck[1]++;
                break;
            case 'B': RGBCheck[2]++;
                break;
        }
    }
}
