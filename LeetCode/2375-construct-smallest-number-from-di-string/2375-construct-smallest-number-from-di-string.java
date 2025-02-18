class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int start = 1;
        for (char c: pattern.toCharArray()) {
            stack.push(start);

            if (c == 'I') {
                appendAll(stack, sb);
            }
            start++;
        }

        stack.push(start);
        appendAll(stack, sb);

        return sb.toString();
    }

    public static void appendAll(Stack<Integer> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}