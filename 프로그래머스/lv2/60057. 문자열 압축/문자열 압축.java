class Solution {
	
    public int solution(String s) {
        int answer = s.length();
        int count = 1;
        String prev = "";
        String next = "";
        String sentence;
        
        for(int i=1; i<=s.length()/2; i++){
        	sentence = "";
            prev = s.substring(0, i);
            
            for(int j=i; j<=s.length(); j+=i){
                int end = Math.min(j + i, s.length());
                next = s.substring(j, end);
                
                if(prev.equals(next)) count++;                
                else {
                	if(count >= 2) sentence += count;                    
                    sentence += prev;
                    prev = next;     
                    count = 1;
                }
            }
            sentence += prev;
            answer = Math.min(answer, sentence.length());
        }
        return answer;
    }
}