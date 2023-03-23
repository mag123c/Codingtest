class Solution {
    public int solution(String s) {
        int answer = 1;
        
        int f=1; int l=0;
        int left = 0; int right = 1;        
        while(right < s.length()) {            
        	if(f == l) {
        		left = right;
        		right += 1;
        		f=1; l=0;
        		answer++;
        	}
        	else {
        		if(s.charAt(left) == s.charAt(right)) {
            		f++;
            	}
            	else {
            		l++;
            	}
            	right++;
        	}
        	
        }        
        
        return answer;
    }
}