import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = br.readLine()).equals("#")) {
            char target = line.charAt(0);
            String sentence = line.substring(2);
            
            int count = 0;
            for (char c : sentence.toCharArray()) {
                if (Character.toLowerCase(c) == target) {
                    count++;
                }
            }

            System.out.println(target + " " + count);
        }
    }
}
