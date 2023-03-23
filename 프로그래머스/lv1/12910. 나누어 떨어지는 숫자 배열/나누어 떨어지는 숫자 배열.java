import java.util.ArrayList;
import java.util.Arrays;

class Solution {
   public int[] solution(int[] arr, int divisor) {
		ArrayList<Integer> arr1 = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
        	if(arr[i]%divisor==0) {
        		arr1.add(arr[i]);
        		cnt++;
        	}
         }
       if(cnt==0) {
    		arr1.add(-1);
    	}
        
    	int[] answer = new int[arr1.size()];

        for(int i=0; i<arr1.size(); i++) {
        	answer[i]=arr1.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}