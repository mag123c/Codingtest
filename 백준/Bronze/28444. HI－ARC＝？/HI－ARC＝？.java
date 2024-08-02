import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int H = scanner.nextInt();
        int I = scanner.nextInt();
        int A = scanner.nextInt();
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        
        int firstTerm = H * I;
        
        int secondTerm = A * R * C;
        
        int result = firstTerm - secondTerm;
        
        System.out.println(result);
        
        scanner.close();
    }
}
