class Solution {
	
    public int solution(int[] arr) {
        int answer = 0;
        
        if(arr.length == 1) {
        	return arr[0];
        }
        
        int a = leastmul(arr[0], arr[1]); 
        answer = (arr[0] * arr[1]) / a; 
        if(arr.length > 2) { 
            for(int i = 2; i < arr.length; i++) {
                a = leastmul(answer, arr[i]);
                answer = (answer * arr[i]) / a;
            }
        }

        return answer;
    }


    int leastmul(int a, int b) {    	
        int c = a%b;
        if(c==0) {
        	return b;
        }
        else{
        	return leastmul(b, c);
        }
    }
}