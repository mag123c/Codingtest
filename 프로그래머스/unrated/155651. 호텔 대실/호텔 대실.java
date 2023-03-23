class Solution {
    public int solution(String[][] book_time) {
    	int answer = 0;
    	int[] fulltime = new int[24*60+10];
    	int[][] time = new int[book_time.length][2];
    	int idx = 0;
        for(String[] book : book_time) {
        	time[idx][0] = time(book[0]);
        	time[idx][1] = time(book[1]) + 10;
            idx++;
        }
        
        for(int[] t : time) {
        	fulltime[t[0]]++;
        	fulltime[t[1]]--;
        }
        
        for(int i=1; i<fulltime.length; i++) {
        	fulltime[i] += fulltime[i-1];
        	answer = Math.max(answer, fulltime[i]);
        }
        
        return answer;
    }
    
    public int time(String book) {
    	int hour = Integer.parseInt(book.split(":")[0]) * 60;
    	int min = Integer.parseInt(book.split(":")[1]);
    	
    	return hour + min;
    }
}