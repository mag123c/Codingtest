import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> attendance = new HashMap<>();

        for (int i = 0; i < N; i ++) {
             st = new StringTokenizer(br.readLine(), " ");

             attendance.put(st.nextToken(), st.nextToken());
        }

        ArrayList<String> people = new ArrayList<>();
        for (String key: attendance.keySet()) {
            if (attendance.get(key).equals("enter")) {
                people.add(key);
            }
        }

        Collections.sort(people, Collections.reverseOrder());

        for (String person: people) {
            bw.write(person + "\n");
        }

        bw.flush();
        bw.close();

    }

}