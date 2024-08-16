import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 옷걸이의 개수
        int N = Integer.parseInt(br.readLine());
        
        // 옷걸이의 종류 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] hangers = new int[N];
        
        int upperOnly = 0; // 상의만 걸 수 있는 옷걸이 개수
        int lowerOnly = 0; // 하의만 걸 수 있는 옷걸이 개수
        int both = 0; // 상의와 하의 모두 걸 수 있는 옷걸이 개수
        
        for (int i = 0; i < N; i++) {
            hangers[i] = Integer.parseInt(st.nextToken());
            if (hangers[i] == 1) upperOnly++;
            else if (hangers[i] == 2) lowerOnly++;
            else if (hangers[i] == 3) both++;
        }
        
        // 상의와 하의의 수 입력 받기
        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        // 가능한지 체크
        if (U <= upperOnly + both && D <= lowerOnly + both) {
            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            
            // 상의 걸기
            for (int i = 0; i < N; i++) {
                if (U > 0 && hangers[i] == 1) {
                    sb.append('U');
                    U--;
                } else if (D > 0 && hangers[i] == 2) {
                    sb.append('D');
                    D--;
                } else if (hangers[i] == 3) {
                    if (U > 0) {
                        sb.append('U');
                        U--;
                    } else if (D > 0) {
                        sb.append('D');
                        D--;
                    }
                }
            }
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
