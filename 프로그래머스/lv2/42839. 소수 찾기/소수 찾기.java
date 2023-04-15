import java.util.HashSet;
import java.util.Set;

class Solution {
	
	static Set<Integer> set = new HashSet<>();
	char[] ch = new char[] {};
	boolean[] bl = new boolean[] {};
			
	
    public int solution(String numbers) {
    	ch = numbers.toCharArray();
    	bl = new boolean[ch.length];
    	int idx = 0;
    	
    	find("", 0);    	
    	
    	return set.size();
    }
    
    void find(String word, int idx) {
    	if(idx>ch.length) return;
    	int num;
    	if(word!="") {
    		num = Integer.parseInt(word);
    		if(primeCheck(num)) set.add(num);
    	}
    	
    	for(int i=0; i<ch.length; i++) {
    		if(bl[i]) continue;
    		bl[i]=true;
    		find(word+ch[i], idx+1);    		
    		bl[i]=false;
    	}
    }

	private boolean primeCheck(int num) {
		if(num==0 || num==1) return false;
		for(int i=2; i*i<num; i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}