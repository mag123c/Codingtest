import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	
    public static void main(String[] args) throws IOException{    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	    	
    	String s = br.readLine();
    	
    	int a = Integer.parseInt(s.split(" ")[0]);
    	int b = Integer.parseInt(s.split(" ")[1]);
    	
    	bw.write(numcheck(a, b));
    	bw.close();    	
    
    }

	private static String numcheck(int a, int b) {
		if(a > b) return ">";
		else if(a < b) return "<";
		else return "==";		
	}


}