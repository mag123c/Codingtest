import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int T = Integer.parseInt(br.readLine());	
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<T; i++) {
			String p = br.readLine();			
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			StringTokenizer st = new StringTokenizer(arr.substring(1, arr.length()-1), ",");			
			List<Integer> list = new ArrayList<>();
			
			while(st.hasMoreElements()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			if(errorCheck(p, n)) {
				sb.append("error\n");
				continue;
			}
			
			else {
				funcAC(p, n, list, 0);
				sb.append("[");
				for(int l=0; l<list.size(); l++) {
					sb.append(list.get(l));
					if(l < list.size()-1) {
						sb.append(",");
					}					
				}
				sb.append("]\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
	
	private static boolean errorCheck(String p, int n) {
		p = p.replace("RR", "");
		int Dnum = 0;
		char[] parr = p.toCharArray();
		for(char pchar : parr) {
			if(pchar == 'D') Dnum++;
			if(Dnum > n) return true;			
		}
		return false;
	}
	
	private static void funcAC(String p, int n, List<Integer> list, int R) {
		char[] parr = p.toCharArray();
		for(char pchar : parr) {
			if(pchar == 'R') {
				R++;
				continue;
			}
			else {
				if(R%2==0) {
					list.remove(0);
				}
				else list.remove(list.size()-1);
			}			
		}
		if(R%2==1) {
			for(int i=0; i<list.size()/2; i++) {
				int tmp = list.get(i);
				list.set(i, list.get(list.size()-1-i));
				list.set(list.size()-1-i, tmp);
			}
		}
	}
	
}