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
    	int[] Narr = new int[N];
    	
    	for(int i=0; i<N; i++) {
    		int n = Integer.parseInt(br.readLine());
    		Narr[i] = n;
    	}
    	
    	Arrays.sort(Narr);
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i : Narr) {
    		sb.append(i);
    		sb.append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }

}