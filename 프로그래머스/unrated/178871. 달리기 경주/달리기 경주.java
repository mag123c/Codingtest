import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {

    	Map<String, Integer> map1 = new HashMap<>();
    	Map<Integer, String> map2 = new HashMap<>();
    	
    	for(int i=0; i<players.length; i++) {
    		map1.put(players[i], i);
    		map2.put(i, players[i]);
    	}
    	
    	for(int i=0; i<callings.length; i++) {
    		if(map1.containsKey(callings[i])) {
    			String before = map2.get(map1.get(callings[i])-1);
    			int beforeN = map1.get(before);
    			map2.put(map1.get(callings[i])-1, callings[i]);
    			map2.put(map1.get(callings[i]), before);
    			map1.put(before, beforeN+1);
    			map1.put(callings[i], beforeN);
    		}
    	}
    	
    	String[] answer = new String[map2.size()];
    	for(int i=0; i<answer.length; i++) {
    		answer[i] = map2.get(i);
    	}
    	return answer;
    }
}