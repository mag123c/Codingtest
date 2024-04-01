package inflearn.chapter5.c1;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(absoluteBracket(s.split("")));

    }

    private static String absoluteBracket(String[] split) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < split.length; i ++) {

            if (stack.isEmpty() && split[i].equals("(")) {
                stack.push(split[i]);
            }
            else if (stack.isEmpty() && split[i].equals(")")) {
                return "NO";
            }
            else if (stack.peek().equals("(") && split[i].equals(")")) {
                stack.pop();
            }
            else stack.push(split[i]);


        }

        return stack.isEmpty() ? "YES" : "NO";


    }


}
