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
    	
    	bw.write(alpabet(s));
    	bw.close();
    }

	private static String alpabet(String s) {
		int[] alpabet = new int[26];
		
		String lower = s.toLowerCase();
		
		for(int i=0; i<lower.length(); i++) {
			int chartoint = lower.charAt(i)-97;
			alpabet[chartoint]++;
		}
		
		int max = -1;
		int idx = -1;
		for(int i=0; i<alpabet.length; i++) {
			if(max < alpabet[i]) {
				max = alpabet[i];
				idx = i;
			}
		}
		
		Arrays.sort(alpabet);
		if(alpabet[alpabet.length-1] == alpabet[alpabet.length-2]) return "?";
		else {
			char c = (char) (idx+65);
			return String.valueOf(c);
		}
		
	}
}