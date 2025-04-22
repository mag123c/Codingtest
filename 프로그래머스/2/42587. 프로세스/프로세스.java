import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < priorities.length; i ++) {
            que.offer(i);
        }

        int[] sorted = Arrays.stream(priorities)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int answer = 0;

        while(!que.isEmpty()) {
            int current = que.poll();
            if (sorted[answer] <= priorities[current]) {
                answer++;

                if (current == location) {
                    break;
                }
            }

            else que.offer(current);
        }

        return answer;
    }
}