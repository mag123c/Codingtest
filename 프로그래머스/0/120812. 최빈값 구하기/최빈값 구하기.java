import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        int[] compare = new int[1001];
        
        for (int i = 0; i < array.length; i ++) {
            compare[array[i]]++;            
        }        
        
        int max = 0;
        int answer = -1;
        
        for (int i = 0; i < 1001; i ++) {
            if (max == compare[i]) {
                answer = -1;
            }
            else if (compare[i] > max) {
                max = compare[i];
                answer = i;
            }
        }
        
        return answer;
    }
}