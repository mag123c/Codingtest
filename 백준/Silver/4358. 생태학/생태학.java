import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tree;
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        while((tree = br.readLine()) != null && !tree.isEmpty()) {
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            count++;
        }

        int mapSize = map.size();
        String[][] arr = new String[mapSize][2];

        int idx = 0;
        for (String s : map.keySet()) {
            arr[idx][0] = s;
            arr[idx][1] = String.valueOf(map.get(s));
            idx++;
        }

        Arrays.sort(arr, (o1, o2) -> o1[0].compareTo(o2[0]));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (String[] str : arr) {
            double percent = (double) Integer.valueOf(str[1]) / count * 100;
            bw.write(String.format("%s %.4f\n", str[0], percent));
        }

        bw.flush();
        bw.close();
    }
}
