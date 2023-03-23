import java.util.Arrays;
import java.util.Comparator;

class Solution {
    int solution(int n, int[][] costs) {		
		
		Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		int tmp = 0;
		int length = 0;
		int answer = 0;		
	
		for(int i=0; i<costs.length; i++) {
			if(length==n-1) break;
			
			if(costs[i][0]!=costs[i][1]) {
				answer += costs[i][2];
			}
			
			int cnt = 0;
			tmp=costs[i][1];
			costs[i][1]=costs[i][0];
			
			while(true) {
				if(costs[cnt][0]==tmp) costs[cnt][0]=costs[i][0];
				if(costs[cnt][1]==tmp) costs[cnt][1]=costs[i][0];
				cnt++;
				
				if(cnt==costs.length) break;			
			}			
			
		}			
		return answer;
	}
}