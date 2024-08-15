import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalMonths = Integer.parseInt(st.nextToken());
            int daysInMonth = Integer.parseInt(st.nextToken());
            int daysInWeek = Integer.parseInt(st.nextToken());

            int totalWeeks = 0;
            int currentDayPosition = 0;

            for (int month = 0; month < totalMonths; month++) {
                totalWeeks += (currentDayPosition + daysInMonth - 1) / daysInWeek + 1;
                currentDayPosition = (currentDayPosition + daysInMonth) % daysInWeek;
            }

            System.out.println("Case #" + i + ": " + totalWeeks);
        }
    }
}
