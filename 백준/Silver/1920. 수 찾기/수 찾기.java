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
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] Narr = new int[N];    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	for(int i=0; i<N; i++) {
    		Narr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(Narr);
    	    	
    	int M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine(), " ");
    	
    	for(int i=0; i<M; i++) {
    		int mdouble = Integer.parseInt(st.nextToken());
    		
    		if(binarySearch(mdouble, Narr) >= 0) {
    			bw.write("1");
    		}
    		else bw.write("0");
    		
    		bw.newLine();
    		
    	}
    	
    	bw.close();    	
    
    }

	private static int binarySearch(int mdouble, int[] Narr) {
		int left = 0;
		int right = Narr.length-1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(mdouble < Narr[mid]) right = mid - 1;
			else if(mdouble > Narr[mid]) left = mid + 1;
			else return mid;
		}
		
		return -1;
	}

}