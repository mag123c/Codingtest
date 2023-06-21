import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			int score = Integer.parseInt(br.readLine());
			arr[i] = score;
		}
		
		int cut = (int)Math.round((double)(n)/100*15);		
		
		Arrays.sort(arr);
		
		double average = 0;
		
		for(int i=cut; i<arr.length-cut; i++) {
			average += arr[i];
		}
		
		average = Math.round(average/(n-(cut*2)));
		
		System.out.println((int)average);
						
	}
}

