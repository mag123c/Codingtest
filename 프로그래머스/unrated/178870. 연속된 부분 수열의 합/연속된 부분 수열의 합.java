class Solution {
    public int[] solution(int[] sequence, int k) {        

    	int left = 0;
    	int right = 0;
    	int sum = 0;
    	int size = sequence.length;
    	int ans1 = 0;
    	int ans2 = 0;
    	
    	for(right=0; right<sequence.length; right++) {    		
    		sum += sequence[right];
    		
    		while(sum > k) {
    			sum -= sequence[left];
    			left++;
    		}
    		
    		if(sum == k) {
    			if(size > right-left) {
    				size = right-left;
    				ans1 = left;
    				ans2 = right;
    			}
    			else if(size == right-left) {
    				ans1 = Math.min(ans1, left);
    				ans2 = Math.min(ans2, right);
    			}
    		}
    		
    	}
    	
    	return new int[] {ans1, ans2};
    }
}