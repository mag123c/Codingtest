import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y, i + 1);  
        }

        Arrays.sort(points, (a, b) -> a.x == b.x ? a.y - b.y : a.x - b.x);

        for (int i = 1; i < N; i++) {
            System.out.println(points[i].index + " " + points[i-1].index);
        }

        sc.close();
    }

    static class Point {
        int x, y, index;

        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
}
