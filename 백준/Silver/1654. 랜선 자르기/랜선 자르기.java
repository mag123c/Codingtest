import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
	
    public static void main(String[] args) throws IOException{    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int K = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	int[] lan = new int[K];
    	
    	long max = 0;
    	for(int i=0; i<K; i++) {
    		lan[i] = Integer.parseInt(br.readLine());
    		max = Math.max(max, lan[i]);
    	}    	
    	
    	System.out.println(binarySearch(lan, N, ++max));   	
    	
    }

	private static long binarySearch(int[] lan, int n, long max) {
		long left = 0;		
		
		while(left < max) {
			long mid = (left + max)/2;
			long total_lan = 0;

			for(int i : lan) total_lan += i/mid;			
			
			if(total_lan < n) max = mid;
			else left = mid + 1;
			
			
		}
		return left - 1;
	}
}