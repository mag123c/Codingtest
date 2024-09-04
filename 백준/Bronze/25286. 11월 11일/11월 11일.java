import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());

            Calendar cal = Calendar.getInstance();
            cal.set(year, month - 1, 1);
            cal.add(Calendar.DATE, -1);

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy M d");
            String formatted = format1.format(cal.getTime());
            System.out.println(formatted);
        }
    }
}
