class Solution {
    public int solution(String[] board) {
        int o = 0;
        int x = 0;
        int oWin = 0;
        int xWin = 0;
        
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		if(board[i].charAt(j) == 'O') {
        			o++;
        		}
        		else if(board[i].charAt(j) == 'X') {
        			x++;
        		}
        	}        	
        }

        if(o-x>1 || o-x<0) { //o가 x보다 2개이상일 때, o보다x가 클 때
        	return 0;
        }        
        
        if(o>=3) {
        	oWin = winnerCheck(board, 'O');     	
        }
        
        if(x>=3) {
        	xWin = winnerCheck(board, 'X');
        }
        
        if(oWin == 1 && xWin == 1) {
        	return 0;
        }
        
        if(oWin == 1) {
        	if(o-x == 1) {
        		return 1;
        	}
        	else {
        		return 0;
        	}
        }
        
        if(xWin == 1) {
        	if(x == o) {
        		return 1;
        	}
        	else {
        		return 0;
        	}
        }

		return 1;
		
    }
    
    public int winnerCheck(String[] board, char ox) {
    	
    	boolean bl = true;
        //1. 가로체크
        for(int i=0; i<3; i++) {
        	bl = true;
        	for(int j=0; j<3; j++) {
        		if(board[i].charAt(j) != ox) {
        			bl = false;     		
        		}
        	}
        	if(bl) {
        		return 1;
        	}
        }
        //2. 세로체크
        for(int i=0; i<3; i++) {
        	bl = true;
        	for(int j=0; j<3; j++) {
        		if(board[j].charAt(i) != ox) {
        			bl = false;     		
        		}
        	}
        	if(bl) {
        		return 1;
        	}
        }

        //3. 대각선체크
        if(board[0].charAt(0) == ox && board[1].charAt(1) == ox && board[2].charAt(2) == ox) {
        	return 1;
        }
        if(board[0].charAt(2) == ox && board[1].charAt(1) == ox && board[2].charAt(0) == ox) {
        	return 1;
        }
        
        return 0;
        

    }
}