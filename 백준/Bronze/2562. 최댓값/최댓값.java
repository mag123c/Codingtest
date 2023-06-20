import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	
    public static void main(String[] args) throws IOException{    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int max = 0;
    	int idx = 0;
    	for(int i=1; i<=9; i++) {
    		int number = Integer.parseInt(br.readLine());    		
            
    		if(max < number) {
    			max = number;
    			idx = i;
    		}
    	}
    	
    	bw.write(Integer.toString(max));
    	bw.newLine();
    	bw.write(Integer.toString(idx));
    	
    	bw.close();    	
    
    }

}