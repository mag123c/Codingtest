import java.util.Arrays;

class Solution{

    public int solution(int[] numbers) {
        int answer = 0;       
        
        Arrays.sort(numbers);
                
        for(int i=0; i<numbers[numbers.length-1]; i++) {
        	int cnt = 0;
        	for(int j=0; j<numbers.length; j++) {
        		if(i<=numbers[j]) cnt++;
        	}
        	if(cnt>=i) answer=i;
        }
        

        
        return answer;
    }
}