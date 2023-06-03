import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int idx = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<idx; i++) {
        	String str = sc.nextLine();
	        String[] arr = str.split(" ");
	        
	        for(int j=0; j<arr.length; j++){
	            String reverse = "";
	            for(int k=arr[j].length()-1; k>=0; k--){
	                reverse += arr[j].charAt(k);
	            }
	            arr[j] = reverse;
	        }
	        
	        String answer = "";
	        for(String s : arr) answer += s + " ";	        
	        System.out.println(answer.trim());
        }
    }
}