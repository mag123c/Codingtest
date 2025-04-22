import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = Arrays.stream(scoville)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        int answer = 0;

        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();

            pq.offer(first + second * 2);
            answer++;
        }

        return pq.peek() >= K ? answer : -1;

    }
}