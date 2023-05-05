import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {	
	int answer = -1;
	
    public int solution(int N, int number) {
    	List<Set<Integer>> list = new ArrayList<Set<Integer>>();
    	list.add(null);
    	list.add(new HashSet<Integer>());
    	list.get(1).add(N);   	
    	
    	dp(N, number, list);
    	
    	System.out.println(answer);
    	return answer;
    }
    
    public void dp(int N, int number, List<Set<Integer>> list) {    	
    	
    	for(int i=1; i<=8; i++) {
    		if(i>=2) {
    			list.add(new HashSet<Integer>());
    			StringBuilder sb = new StringBuilder();
    			for(int j=0; j<i; j++) {    				
    				sb.append(N);
    			}
    			list.get(i).add(Integer.parseInt(sb.toString()));
    			
    			for(int j=1; j<i; j++) {
    				for(int k : list.get(j)) {
    					for(int l : list.get(i-j)) {
    						list.get(i).add(k+l);
    						list.get(i).add(k-l);
    						list.get(i).add(k*l);
    						if(l!=0) list.get(i).add(k/l);
    					}
    				}
    			}
    		}
    		if(chk(list.get(i), number, i)) return;
    	}
    	
    }
    
    public boolean chk(Set<Integer> set, int number, int idx) {
    	if(set.contains(number)) {
    		answer = idx;
    		return true;
    	}
    	return false;
    }

}
