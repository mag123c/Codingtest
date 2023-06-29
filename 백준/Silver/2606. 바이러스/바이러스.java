import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int computer = Integer.parseInt(br.readLine());        
        int connection = Integer.parseInt(br.readLine());        
        int[][] node = new int[computer + 1][computer + 1];
        int[] arr = new int[computer + 1];
        StringTokenizer st;
        
        arr[1] = 1;
        
        for(int i = 0; i < connection; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	node[a][b] = node[b][a] = 1;        	
        }
        
        int cnt = 0;        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while(!queue.isEmpty()) {
        	int chk = queue.poll();
        	
        	for(int i = 1; i < arr.length; i++) {
        		if(node[chk][i] == 1 && arr[i] != 1) {
        			cnt++;
        			arr[i] = 1;
        			queue.add(i);
        		}
        	}
        }
        
        System.out.println(cnt);

    }

	private static void union(int a, int b, int[] node) {
		a = find(a, node);
		b = find(b, node);
		if(a != b) node[b] = a;		
	}

	private static int find(int a, int[] node) {
		if(node[a] == a) return a;
		else return node[a] = find(node[a], node);
	}       
    
}
