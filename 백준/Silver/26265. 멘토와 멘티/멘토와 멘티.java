import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<String[]> arr = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] entry = new String[2];
            entry[0] = st.nextToken();
            entry[1] = st.nextToken();
            arr.add(entry);
        }

        arr.sort((o1, o2) -> {
            if (!o1[0].equals(o2[0])) {
                return o1[0].compareTo(o2[0]);
            } else {
                return o2[1].compareTo(o1[1]);
            }
        });

        for (String[] entry : arr) {
            bw.write(entry[0] + " " + entry[1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
