import java.util.Arrays;

class Solution {
    public long solution(int[] sequence) {
        if(sequence.length == 1) return Math.abs(sequence[0]);
        
        long[] plus = new long[sequence.length];
        long[] minus = new long[sequence.length];
        plus[0] = sequence[0];
        minus[0] = sequence[0]*-1;
        for(int i=1; i<sequence.length; i++) {
        	if(i%2==0) {
        		plus[i] = Math.max(plus[i-1] + sequence[i], sequence[i]);
        		minus[i] = Math.max(minus[i-1] + sequence[i]*-1, sequence[i]*-1);
        	}
        	else {
        		plus[i] = Math.max(plus[i-1] + sequence[i]*-1, sequence[i]*-1);
        		minus[i] = Math.max(minus[i-1] + sequence[i], sequence[i]);
        	}
        }
        
        Arrays.sort(plus);
        Arrays.sort(minus);
        
        return Math.max(plus[sequence.length-1], minus[sequence.length-1]);
        
    }    
}