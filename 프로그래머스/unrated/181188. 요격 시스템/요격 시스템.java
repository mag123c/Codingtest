import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int before = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1]-o2[1]);
        for(int i=0; i<targets.length; i++) {
        	if(targets[i][0] >= before) {
        		before = targets[i][1];
        		answer++;
        	}
        }
        return answer;
    }
}