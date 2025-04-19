import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        // 각 작업 별 걸리는 시간
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i ++) {
            days[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
        }

        int prev = days[0];
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {
            if (days[i] <= prev) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                prev = days[i];
            }
        }

        answer.add(count);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}