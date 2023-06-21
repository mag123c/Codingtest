import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
	
    public static void main(String[] args) throws IOException{    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] five = new int[N/5+1];
    	five[0] = N;
    	
    	if(N%5 ==0) {
    		System.out.println(N/5);
    		return;
    	}
    	
    	for(int i=1; i<five.length; i++) {
    		five[i] = N-(i*5);
    	}
    	
    	for(int i=five.length-1; i>=0; i--) {
    		if(five[i]%3 == 0) {
    			int three = five[i]/3;
    			System.out.println(three + i);
    			return;
    		}
    	}
    	
    	System.out.println(-1);
    	
    }

}