import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int N = (int) Math.pow(3, Integer.parseInt(line));

            StringBuilder sb = initialize("-", N);
            divide(sb, 0, sb.length());

            print(sb.toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }

    private static void divide(StringBuilder sb, int start, int end) {
        int length = end - start;
        if (length < 3) {
            return;
        }
        int part1End = start + length / 3;
        int part2Start = start + 2 * (length / 3);

        merge(sb, part1End, part2Start);

        divide(sb, start, part1End);
        divide(sb, part2Start, end);
    }

    private static void merge(StringBuilder sb, int part1End, int part2Start) {
        for (int i = part1End; i < part2Start; i++) {
            sb.setCharAt(i, ' ');
        }
    }

    private static StringBuilder initialize(String word, int N) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i ++) {
            sb.append(word);
        }

        return sb;
    }

    private static void print(String value) throws IOException {
        bw.write(value);
    }
}
