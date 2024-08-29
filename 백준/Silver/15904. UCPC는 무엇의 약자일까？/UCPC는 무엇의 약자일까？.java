import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Sentence = sc.nextLine();
        int index = 0;    
        int length = Sentence.length();
        
        index += findIndex(Sentence, "U");
        index += findIndex(Sentence.substring(index, length), "C");
        index += findIndex(Sentence.substring(index, length), "P");
        findIndex(Sentence.substring(index, length), "C");

        System.out.println("I love UCPC");
    }

    private static int findIndex(String sentence, String letter) {
        int index = sentence.indexOf(letter);
        if (index == -1) {
            System.out.println("I hate UCPC");
            System.exit(0);
        }
        return index;
    }
}
