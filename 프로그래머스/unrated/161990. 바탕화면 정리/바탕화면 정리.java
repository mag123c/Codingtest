class Solution {

    public int[] solution(String[] wallpaper) {
    	
    	int top = Integer.MAX_VALUE;
    	int left = Integer.MAX_VALUE;
    	int bottom = Integer.MIN_VALUE;
    	int right = Integer.MIN_VALUE;
    	
    	for(int i=0; i<wallpaper.length; i++) {
    		for(int j=0; j<wallpaper[i].length(); j++) {
    			if(wallpaper[i].charAt(j)=='#') {
    				top = Math.min(top, i);
    				left = Math.min(left, j);
    				bottom = Math.max(bottom, i);
    				right = Math.max(right, j);
    			}
    		}
    	}
    	return new int[] {top, left, bottom+1, right+1};
    	
    }
}