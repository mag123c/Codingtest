import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	
    public static void main(String[] args) throws IOException{    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int test = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<test; ++i) {   		
			String ox = br.readLine();
			
			int num = 0;
			int total = 0;
			for(int j=0; j<ox.length(); j++) {
				if(ox.charAt(j) == 'O') num++;
				else num = 0;
				
				total += num;
			}
			System.out.println(total);
		}   	
    	
    	bw.close();    	
    
    }

}