import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numBuildings = Integer.parseInt(br.readLine());
        
        int[] heights = new int[numBuildings];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numBuildings; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[][] visibilityCheck = new boolean[numBuildings][numBuildings];
        for (int i = 0; i < numBuildings; i++) {
            for (int j = i + 1; j < numBuildings; j++) {
                double slope = (double)(heights[j] - heights[i]) / (j - i);
                int step = 1;
                boolean isVisible = true;
                
                while (i + step < j) {
                    if (((double)heights[i] + (slope * step)) <= (double)heights[i + step]) {
                        isVisible = false;
                        break;
                    }
                    step++;
                }
                
                if (isVisible) {
                    visibilityCheck[i][j] = true;
                    visibilityCheck[j][i] = true;
                }
            }
        }
        
        int maxVisible = 0;
        for (int i = 0; i < numBuildings; i++) {
            int visibleCount = 0;
            for (int j = 0; j < numBuildings; j++) {
                if (visibilityCheck[i][j]) visibleCount++;
            }
            maxVisible = Math.max(visibleCount, maxVisible);
        }

        System.out.println(maxVisible);
        br.close();
    }
}
