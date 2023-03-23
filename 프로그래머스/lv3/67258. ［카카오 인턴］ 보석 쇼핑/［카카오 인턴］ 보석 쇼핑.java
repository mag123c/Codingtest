import java.util.*;

class Solution {
public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        
        for(String str : gems) {
        	set.add(str);
        }
        
        int cnt=0;
        int start=0;
        int end= gems.length;
        
        
        for(String str : gems) {        	
        	q.offer(str);
        	map.put(str, map.getOrDefault(str, 0)+1);
        	
        	while(true) {
        		String peek = q.peek();
        		
        		if(map.get(peek)>1) {
        			q.poll();
        			map.put(peek, map.getOrDefault(peek, 0)-1);
        			cnt++;
        		}
        		else {        		
        			break;
        		}
        	}
        	
        	if(map.size()==set.size()) {
        		if(end>q.size()) {
	            	end=q.size();
	            	start=cnt;
        		}            	
            }        	
        }
        int[] answer = {start+1, start+end};
    
        return answer;
    }
	
}