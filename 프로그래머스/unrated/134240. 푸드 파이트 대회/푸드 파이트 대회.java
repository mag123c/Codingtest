class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i<food.length; i++) {
        	if(food[i]<=1) food[i]=0;
        	if(food[i]%2==1) food[i]-=1;
        	food[i]=(food[i]/2);
        	
        }
        
        
        for(int i=1; i<food.length; i++) {
        	int cnt = 0;
        	while(true) {
        		if(food[i]==0) {
        			break;
        		}
        		answer+=String.valueOf(i);
        		cnt++;
        		if(cnt==food[i]) {
        			break;
        		}
        	}
        }
        StringBuffer sb = new StringBuffer(answer);
        answer += "0"+sb.reverse();        
        
        return answer;
    }
}