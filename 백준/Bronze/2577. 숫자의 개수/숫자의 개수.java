import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	
    public static void main(String[] args) throws IOException{    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int A = 0;
    	int B = 0;
    	int C = 0;
    	for(int i=1; i<=3; i++) {    		    		
    		switch(i) {
    		case 1 : A = Integer.parseInt(br.readLine());
    		break;
    		case 2 : B = Integer.parseInt(br.readLine());
    		break;
    		case 3 : C = Integer.parseInt(br.readLine());
    		break;
    		}
    	}
    	
    	String mul = Integer.toString(A*B*C);   	
    	    	
    	int[] arr = new int[10];
    	
    	for(String s : mul.split("")) {
    		arr[Integer.parseInt(s)]++;
    	}
    	
    	for(int arr_num : arr) {
    		bw.write(Integer.toString(arr_num));
    		bw.newLine();
    	}
    	
    	bw.close();    	
    
    }

}