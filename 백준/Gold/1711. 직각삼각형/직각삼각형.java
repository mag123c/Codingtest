import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Point {
    long x, y;
    
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }
            
        long count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    long x1 = points[i].x;
                    long y1 = points[i].y;
                    long x2 = points[j].x;
                    long y2 = points[j].y;
                    long x3 = points[k].x;
                    long y3 = points[k].y;
                    
                    long dist1 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                    long dist2 = (x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3);
                    long dist3 = (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3);
                    
                    if (dist1 + dist2 == dist3 || dist1 + dist3 == dist2 || dist2 + dist3 == dist1) {
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}