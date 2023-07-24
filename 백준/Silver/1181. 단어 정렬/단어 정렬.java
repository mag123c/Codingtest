import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i ++) {
            set.add(br.readLine());
        }

        String[] arr = new String[set.size()];
        Iterator<String> itor = set.iterator();
        int length = arr.length;
        for(int i = 0; i < length; i ++) {
            arr[i] = itor.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else return o1.length() - o2.length();
            }
        });

        StringBuffer sb = new StringBuffer();

        for(String s : arr) sb.append(s + "\n");

        System.out.println(sb.toString());
    }
}
