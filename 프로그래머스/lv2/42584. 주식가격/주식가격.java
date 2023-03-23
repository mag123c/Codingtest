class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
        	for(int j=i+1; j<prices.length-1; j++) {
        		if(prices[i] > prices[j]) {
        			answer[i] = j-i;
                    break;
        		}
        	}
        }
        for(int i=0; i<answer.length; i++) {
        	if(answer[i] == 0) {
        		answer[i] = (answer.length-1) - i;
        	}
        }
        
        return answer;
    }
    {}
}