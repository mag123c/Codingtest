import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        List<Integer> list = new ArrayList<>(section.length);
        for(int i : section) {
        	list.add(i);
        }
        
        List<Integer> list2 = new ArrayList<>();
        boolean a = true;
        while(a) {
        	list2 = cal(list, m);
        	answer ++;
        	if(list2.size() == 0) {
        		a=false;
        	}
        }
        
        return answer;
    }
    
    public List<Integer> cal(List<Integer> list, int m){
        int start = list.get(0) + m -1; //시작 구간부터 한번에 칠 할수있는 구간까지
        int tmp = 0;
        
        if(list.size() == 1) { //마지막 하나의 경우
        	list.remove(0);
        	return list;
        }
        
        for(int i=0; i<list.size(); i++) {
        	if(list.get(i) > start) {
        		tmp = i;
        		break;
        	}
        }
        
        if(tmp == 0) { //한번에 다 될 경우
        	tmp = list.size();
        }
        
        for(int i=0; i<tmp; i++) {
        	list.remove(0);
        }
        return list;
    }
    
    
    public static void main(String[] args) {
		int n = 5, m = 4;
		int[] section = {1,3};
		Solution sol = new Solution();
		sol.solution(n, m, section);
	}
}