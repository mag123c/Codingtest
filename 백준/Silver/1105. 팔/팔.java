import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String[] numbers = input.split(" ");

        String firstNumber = numbers[0];
        String secondNumber = numbers[1];

        if (firstNumber.length() != secondNumber.length()) {
            System.out.println(0);
            return;
        }

        int matchingCount = countMatchingEights(firstNumber, secondNumber);
        System.out.println(matchingCount);
    }

    private static int countMatchingEights(String first, String second) {
        int count = 0;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == '8' && second.charAt(i) == '8') {
                count++;
            } else if (first.charAt(i) != second.charAt(i)) {
                break; 
            }
        }

        return count;
    }
}
