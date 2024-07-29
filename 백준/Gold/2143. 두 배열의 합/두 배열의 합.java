import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long[] nArr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++) {
            nArr[i] = Integer.parseInt(st.nextToken());            
        }

        int m = Integer.parseInt(br.readLine());
        long[] mArr = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i ++) {
            mArr[i] = Integer.parseInt(st.nextToken());            
        }

        br.close();


        HashMap<Long, Long> nMap = calculateSubtotals(n, nArr);
        HashMap<Long, Long> mMap = calculateSubtotals(m, mArr);

        long cnt = 0;
        for (long nKey: nMap.keySet()) {
            long tmp = T - nKey;
            if (mMap.containsKey(tmp)) {
                cnt += nMap.get(nKey) * mMap.get(tmp);
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static HashMap<Long, Long> calculateSubtotals(int x, long[] arr) {
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < x; i++) {
            long sum = 0;
            for (int j = i; j < x; j++) {
                sum += arr[j];
                map.put(sum, map.getOrDefault(sum, (long) 0) + 1);
            }
        }
        return map;
    }
}
