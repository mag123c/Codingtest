import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());
		int tmp = 1;
		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<>();
		stack.push(tmp);
		sb.append("+\n");
		for(int i = 0; i < n; i ++) {
			int num = Integer.parseInt(br.readLine());
			
			while(tmp != num) {
				if(tmp < num) {
					tmp++;
					stack.push(tmp);
					sb.append("+\n");
				}
				else if(stack.peek() == num) {
					break;
				}
				else {
					sb.setLength(0);
					sb.append("NO");
					System.out.println(sb);
					return;
				}
			}
			stack.pop();
			sb.append("-\n");
		}
		
		System.out.println(sb);
	}
}