import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main{
	
    public static void main(String[] args) throws IOException{    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] Narr = new int[2000001];
    	
    	for(int i=0; i<N; i++) {
    		int n = Integer.parseInt(br.readLine()) + 1000000;
    		Narr[n]++;
    	}   	
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<Narr.length; i++) {
    		if(Narr[i] > 0) sb.append(i-1000000 + "\n");
    	}
    	
    	System.out.println(sb.toString());
    }

}