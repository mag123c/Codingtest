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
			String line = br.readLine();
			int test_num = Integer.parseInt(line.split(" ")[0]);
    		String word = line.split(" ")[1];   		
    		
    		for(int j=0; j<word.length(); j++) {
    			for(int k=0; k<test_num; k++) {
    				System.out.print(word.charAt(j));
    			}
    		}
			System.out.println();
		}   	
    	
    	bw.close();    	
    
    }

}