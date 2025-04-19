import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean solution(String s) {
        if(s.charAt(s.length()-1) == '(') return false;

        Queue<Character> queue = new LinkedList<>();
        queue.add(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
        	if(!queue.isEmpty() && queue.peek() != s.charAt(i)) {
        		queue.poll();
        	}
        	else {
        		if(s.charAt(i) == ')') return false;
        		else queue.add(s.charAt(i));        		
        	}
        }        
        if(queue.isEmpty()) return true;
        else return false;
    }
}