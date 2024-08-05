import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] l = line.split(" ");
            String l1 = l[0];
            String l2 = l[1];
            int l1Len = l1.length();
            int l2Len = l2.length();
            int l1idx = 0;
            int l2idx = 0;

            while (l1idx < l1Len && l2idx < l2Len) {
                if (l1.charAt(l1idx) == l2.charAt(l2idx)) {
                    l1idx++;
                }
                l2idx++;
            }

            if (l1idx == l1Len) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
