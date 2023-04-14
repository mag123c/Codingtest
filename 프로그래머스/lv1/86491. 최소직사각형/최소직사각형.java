class Solution {
    public int solution(int[][] sizes) {        
        int[][] size = new int[sizes.length][2];
        for(int i=0; i<sizes.length; i++) {
        	size[i][0] = Math.max(sizes[i][0], sizes[i][1]);
        	size[i][1] = Math.min(sizes[i][0], sizes[i][1]);
        }
        int x = 0;
        int y =0;
        for(int[] i : size) {
        	x = Math.max(x, i[0]);
        	y = Math.max(y, i[1]);
        }
        return x*y;

    }
}