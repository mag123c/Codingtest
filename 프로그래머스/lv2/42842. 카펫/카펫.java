import java.util.ArrayList;
import java.util.List;

class Solution {

	static List<Integer> list = new ArrayList<>();
	
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown+yellow;       
        div(sum);
        System.out.println(list);
        if(list.size()%2==0) {
        	int x = list.size()/2;
        	int y = list.size()/2-1;
        	while((list.get(x)-2)*(list.get(y)-2)!=yellow) {
        		y--;
        		x++;
        	}
        	answer[0] = list.get(x);
        	answer[1] = list.get(y);
        }
        else {
        	answer[0] = list.get(list.size()/2);
        	answer[1] = list.get(list.size()/2);                
        }        
        return answer;
    }
    
    public void div(int sum) {
    	for(int i=1; i<=sum/2; i++) {
    		if(sum%i==0) {
    			list.add(i);
    		}
    	}
    	list.add(sum);
    }
}