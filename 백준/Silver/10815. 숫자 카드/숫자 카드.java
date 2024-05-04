import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;


        HashMap<Integer, Boolean> card = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            card.put(Integer.parseInt(st.nextToken()), true);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());

            if(card.containsKey(number)) {
                bw.write(String.valueOf(1));
            }
            else bw.write(String.valueOf(0));

            bw.write(" ");
        }

        bw.flush();
        bw.close();

    }

}