import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String[] start = sc.next().split(":");
            String[] end = sc.next().split(":");
            
            int startTime = toSeconds(start);
            int endTime = toSeconds(end);
            
            int count = 0;
            while (startTime != endTime) {
                if (is3Divisible(startTime)) {
                    count++;
                }
                startTime = (startTime + 1) % 86400;  // 24시간은 86400초
            }
            if (is3Divisible(endTime)) {
                count++;
            }
            
            System.out.println(count);
        }
        sc.close();
    }
    
    private static int toSeconds(String[] time) {
        return Integer.parseInt(time[0]) * 3600 + 
               Integer.parseInt(time[1]) * 60 + 
               Integer.parseInt(time[2]);
    }
    
    private static boolean is3Divisible(int seconds) {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;
        return (h + m + s) % 3 == 0;
    }
}
