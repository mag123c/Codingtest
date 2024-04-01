package inflearn.chapter5.c4;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        calculate(s);

    }

    private static void calculate(String s) {

        Stack<String> stack = new Stack<>();
        for (String split : s.split("")) {
            if (!stack.isEmpty() && checkSymbol(split)) {
                int after = Integer.parseInt(stack.pop());
                int before = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(calculateBySymbol(before, after, split)));
            }
            else stack.push(split);
        }

        System.out.println(stack.pop());
    }

    private static boolean checkSymbol (String letter) {

        switch (letter) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }

    }

    private static int calculateBySymbol(int a, int b, String symbol) {

        switch (symbol) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        };
        return 0;
    }

}
