class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        for(int i=1; i<s.length(); i++) {
        	if(s.substring(0, i).contains(String.valueOf(s.charAt(i)))) {
        		answer[i] = i - s.substring(0, i).lastIndexOf(s.charAt(i));
        	}
        	else {
        		answer[i] = -1;
        	}
        }
        
        return answer;
    }
}