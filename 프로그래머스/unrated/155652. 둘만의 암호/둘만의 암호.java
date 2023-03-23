class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        char[] chArr = s.toCharArray();
        for(int i=0; i<chArr.length; i++) {
        	for(int j=0; j<index; j++) {
        		chArr[i]++;
    			if(chArr[i] > 'z') {
        			chArr[i] -= 26;
    			}
        		while(skip.contains(String.valueOf(chArr[i]))) {
        			chArr[i]++;
        			if(chArr[i] > 'z') {
        				chArr[i] -= 26;
        			}
        		}
        	}
        }
        answer = String.valueOf(chArr);
        return answer;
        
    }
}