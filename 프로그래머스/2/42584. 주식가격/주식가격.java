import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i ++) {
            // 가격이 내려간 게 있으면 그만.
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int price = stack.pop();
                answer[price] = i - price;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int price = stack.pop();
            answer[price] = prices.length - 1 - price;
        }

        return answer;
    }
}