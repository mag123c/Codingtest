import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int initialSize = Integer.parseInt(st.nextToken());
        int addCommands = Integer.parseInt(st.nextToken());
        int removeCommands = Integer.parseInt(st.nextToken());

        int currentSize = initialSize;
        int usedSize = 0;
        int maxSize = initialSize;

        for (int i = 0; i < addCommands + removeCommands; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command == 1) {
                if (usedSize == currentSize) {
                    currentSize *= 2;
                    maxSize = Math.max(maxSize, currentSize);
                }
                usedSize++;
            } else {
                usedSize--;
            }
        }

        System.out.println(maxSize);
    }
}
