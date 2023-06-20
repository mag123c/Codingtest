import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main{
	
    public static void main(String[] args) throws IOException{    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String s = br.readLine();
    	
    	int[] arr = new int[26];
    	
    	for(int i=0; i<arr.length; i++) {
    		arr[i] = -1;
    	}
    	
    	for(int i=0; i<s.length(); i++) {    		
    		if(arr[s.charAt(i) - 97] == -1) arr[s.charAt(i) - 97] = i;
    	}
    	
    	for(int i : arr) {    		
    		bw.write(Integer.toString(i) + " ");    		
    	}
    	
    	
    	bw.close();    	
    
    }

}