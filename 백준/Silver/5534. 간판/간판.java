import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String target = sc.nextLine();

        int count = 0; 

        for (int i = 0; i < N; i++) {
            String oldSign = sc.nextLine();
            if (canMakeNewSign(target, oldSign)) {
                count++; 
            }
        }

        System.out.println(count); 
    }

    public static boolean canMakeNewSign(String target, String oldSign) {
        int targetLength = target.length();
        int oldSignLength = oldSign.length();

        for (int start = 0; start < oldSignLength; start++) {
            for (int gap = 1; start + (targetLength - 1) * gap < oldSignLength; gap++) {
                boolean canMake = true;

                for (int j = 0; j < targetLength; j++) {
                    if (oldSign.charAt(start + j * gap) != target.charAt(j)) {
                        canMake = false;
                        break;
                    }
                }

                if (canMake) {
                    return true;
                }
            }
        }

        return false; 
    }
}