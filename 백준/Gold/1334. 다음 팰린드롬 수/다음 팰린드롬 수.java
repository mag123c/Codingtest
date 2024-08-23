import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger input = new BigInteger(br.readLine()).add(BigInteger.ONE);
        
        List<Integer> list = new ArrayList<>();
        for (char c : input.toString().toCharArray()) {
            list.add(Character.getNumericValue(c));
        }

        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j <= list.size() / 2; j++) {
                if (list.get(j) < list.get(list.size() - j - 1)) {
                    list.set(list.size() - j - 2, list.get(list.size() - j - 2) + 1);
                }

                list.set(list.size() - j - 1, list.get(j));

                for (int k = list.size() - 1; k >= 0; k--) {
                    if (list.get(k) >= 10) {
                        list.set(k, list.get(k) % 10);

                        if (k > 0) {
                            list.set(k - 1, list.get(k - 1) + 1);
                        } else {
                            list.add(0, 1);
                        }
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int num : list) {
            result.append(num);
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
