import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];

        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim()  );
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (o1, o2) -> o1[0] - o2[0]);
        ArrayList<Integer> l = new ArrayList<>();
        int[] lisIndices = new int[N];

        for (int i = 0; i < N; i ++) {
            lisIndices[i] = binarySearch(l, line[i][1]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = l.size();
        bw.write(N - len + "\n");

        HashSet<Integer> set = new HashSet<>();
        for (int i = N - 1, k = len - 1; i >= 0 && k >= 0; i--) {
            if (lisIndices[i] == k) {
                set.add(line[i][1]);
                k--;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!set.contains(line[i][1])) {
                bw.write(line[i][0] + "\n");
            }
        }


        bw.flush();
        bw.close();

    }

    private static int binarySearch(ArrayList<Integer> l, int endLine) {
        int start = 0;
        int end = l.size();
        while(start < end) {
            int mid = (start + end) / 2;

            if (l.get(mid) >= endLine) {
                end = mid;
            }

            else {
                start = mid + 1;
            }
        }

        if (start >= l.size()) {
            l.add(endLine);
        }
        else l.set(start, endLine);

        return start;
    }
}