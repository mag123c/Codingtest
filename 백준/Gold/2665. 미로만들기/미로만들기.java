import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        board = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                board[i][j] = temp.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(dist[n - 1][n - 1] + "\n");
        bw.flush();
        bw.close();
    }

private static void bfs() {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(0, 0));
    dist[0][0] = 0;

    while (!q.isEmpty()) {
        Node current = q.poll();

        for (int i = 0; i < 4; i++) {
            int nx = current.x + dx[i];
            int ny = current.y + dy[i];

            if (isValid(nx, ny)) {
                int nextDist = dist[current.x][current.y] + (board[nx][ny] == 0 ? 1 : 0);
                if (dist[nx][ny] > nextDist) {
                    dist[nx][ny] = nextDist;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
}


    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}