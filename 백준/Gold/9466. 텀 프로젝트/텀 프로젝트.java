import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int student = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[student + 1];
            boolean[] visited = new boolean[student + 1];
            boolean[] finished = new boolean[student + 1];

            for (int j = 1; j <= student; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            for (int j = 1; j <= student; j++) {
                if (!visited[j]) {
                    cnt += alone(j, arr, visited, finished);
                }
            }

            bw.write((student - cnt) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int alone(int start, int[] arr, boolean[] visited, boolean[] finished) {
        int cycleLength = 0;
        visited[start] = true;
        int next = arr[start];

        if (!visited[next]) {
            cycleLength = alone(next, arr, visited, finished);
        } else if (!finished[next]) {
            // 사이클이 형성된 경우
            for (int current = next; current != start; current = arr[current]) {
                cycleLength++;
            }
            cycleLength++; // 시작점도 카운트
        }

        finished[start] = true; // 탐색 완료 표시
        return cycleLength;
    }
}
