import java.util.ArrayList;
import java.util.List;

class Solution {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
    	List<String> c1 = new ArrayList<>();
    	List<String> c2 = new ArrayList<>();
    	List<String> g = new ArrayList<>();
    	
    	for(String s : cards1) c1.add(s);
    	for(String s : cards2) c2.add(s);
    	for(String s : goal) g.add(s);
        
    	boolean bl = true;
    	while(bl) {
    		if(g.size() == 0) {
    			return "Yes";
    		}
    		if(c1.size() > 0 && g.get(0).equals(c1.get(0))){
    			g.remove(0);
    			c1.remove(0);
    		}
    		else if(c2.size() > 0 && g.get(0).equals(c2.get(0))) {
    			g.remove(0);
    			c2.remove(0);
    		}
    		else {
    			bl = false;
    		}
    	}
    	
    	return "No";
    	
    }
}