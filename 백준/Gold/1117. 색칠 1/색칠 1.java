import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long w = sc.nextLong();
        long h = sc.nextLong();
        long f = sc.nextLong();
        long c = sc.nextLong();
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();

        long area = (x2 - x1) * (y2 - y1) * (c + 1);

        if (f <= w / 2) {
            if (f <= x1) { 
                System.out.println(w * h - area);
            } 
            else {
                System.out.println(w * h - (area + (Math.min(f, x2) - x1) * (y2 - y1) * (c + 1)));
            }
        } 
        else { 
            if (w <= x1 + f) { 
                System.out.println(w * h - area);
            } 
            else {
                System.out.println(w * h - (area + (Math.min(w, f + x2) - (f + x1)) * (y2 - y1) * (c + 1)));
            }
        }

        sc.close();
    }
}
