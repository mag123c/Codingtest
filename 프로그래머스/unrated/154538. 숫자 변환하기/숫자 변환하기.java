import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int x, int y, int n) {
		//중복방지 - set
		Set<Integer> set = new HashSet<>();
		Set<Integer> compare = null;
		set.add(x);
		int answer = 0;
		//+n, *2, *3을 계속 진행하여 경우의수 파악
		while(!set.isEmpty()) {
			if(set.contains(y)) {
				return answer;
			}			
			compare = new HashSet<>();
			
			for(int s : set) {
				int xn = s+n;
				int twox = s*2;
				int threex = s*3;
				
				if(xn<=y) {
					compare.add(xn);
				}
				if(twox<=y) {
					compare.add(twox);
				}
				if(threex<=y) {
					compare.add(threex);				
				}
			}			
			set = compare;
			answer++;
		}
		return -1;
		
    }
	
}