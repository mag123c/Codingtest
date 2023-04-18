class Solution {
	
	static int join = 0;
	
    public int solution(int k, int[][] dungeons) {        
        boolean[] bl = new boolean[dungeons.length];
        
        dfs(dungeons, bl, 0, k, 0, 0);
        return join;
    }
    
    public void dfs(int[][] dungeons, boolean[] bl, int sum, int k, int join2, int idx){
    	
    	for(int i=0; i<dungeons.length; i++) {
    		if(bl[i]) continue;
    		bl[i] = true;
    		if(k-sum >= dungeons[i][0]) {
    			dfs(dungeons, bl, sum+dungeons[i][1], k, join2+1, idx+1);
    		}    		
    		bl[i] = false;    		
    	}
        join = Math.max(join, join2);

    }
}