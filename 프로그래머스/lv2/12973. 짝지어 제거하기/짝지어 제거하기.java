import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
        	int chk = 0;
        	while(!st.isEmpty() && st.peek() == s.charAt(i)) {
        		st.pop();
        		chk++;
        	}
        	if(chk == 0) st.add(s.charAt(i));
        }
        if(!st.isEmpty()) return 0;
        else return 1;
        
    }
}