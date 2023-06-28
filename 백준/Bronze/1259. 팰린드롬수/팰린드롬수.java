import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String palindrome = br.readLine();
            if(palindrome.equals("0")) break;

            boolean chk = true;

            for(int i = 0; i < palindrome.length() / 2; i++){
                char before = palindrome.charAt(i);
                char after = palindrome.charAt(palindrome.length() - 1 - i);

                if(before != after) {
                    System.out.println("no");
                    chk = false;
                    break;
                }
            }

            if(chk) System.out.println("yes");
        }
    }
}
