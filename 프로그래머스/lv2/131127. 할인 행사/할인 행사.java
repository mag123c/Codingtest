class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
    	
        int answer = 0;     
        
        for(int i=0; i<discount.length-9; i++) {
        	int cntday = 0;
        	for(int j=0; j<want.length; j++) {
        		int cnt = 0;
        		for(int k=i; k<i+10; k++) {
        			if(discount[k].equals(want[j])) cnt++;       			
        		}
        		if(cnt<number[j]) break;
        		else cntday++;
        	}
        	if(cntday == want.length) answer++;
        }
        
        return answer;
    }
}