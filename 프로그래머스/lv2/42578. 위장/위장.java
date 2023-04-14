import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> cloth = new HashMap<>();
        for(String[] cl : clothes) {
        	cloth.put(cl[1], cloth.getOrDefault(cl[1], 0) + 1);
        }
        
        for(String s : cloth.keySet()) {
        	answer *= cloth.get(s)+ 1;
        }
        return answer-1;
    }
}