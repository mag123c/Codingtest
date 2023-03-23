import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());	
		
		for(int worktime : works) queue.offer(worktime);
		System.out.println(queue);
		
		for(int i=0; i<n; i++) {

			int worktime = queue.poll();
			
			if(worktime == 0) {
				break;
			}
			else {
				queue.offer(worktime - 1);
			}
		
		}
		
		
		for(int qu : queue) answer += Math.pow(qu, 2);
        
        return answer;
    }
}