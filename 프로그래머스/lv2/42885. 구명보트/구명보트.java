import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {

        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        for(int i=people.length-1; i>=min; i--) {
        	if(people[min] + people[i] <= limit) {
        		min++;
        	}
        	answer++;
        }
        return answer;
    }
}