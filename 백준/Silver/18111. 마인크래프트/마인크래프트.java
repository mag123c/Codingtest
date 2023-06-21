import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] minecraft = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = -1;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				minecraft[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, minecraft[i][j]);
				max = Math.max(max, minecraft[i][j]);
			}
		}
		
		int min_sec = Integer.MAX_VALUE;
		int high_block = 0;
		for(int i=min; i<=max; i++) {
			int second = 0;
			int block = B;
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(i > minecraft[j][k]) {
						second += i-minecraft[j][k];
						block -= i-minecraft[j][k];
					}
					else if(i < minecraft[j][k]) {
						second += (minecraft[j][k]-i)*2;
						block += minecraft[j][k]-i;
					}
				}
			}
			if(block < 0) continue;
			
			if(min_sec >= second) {
				min_sec = second;
				high_block = Math.max(high_block, i);
			}
		}
		
		System.out.println(min_sec + " " + high_block);		
	}
}

