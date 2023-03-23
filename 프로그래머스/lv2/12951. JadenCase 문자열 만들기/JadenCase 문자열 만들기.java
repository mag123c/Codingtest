class Solution{
    public String solution(String s) {
            String answer = "";
            String[] arr = s.toLowerCase().split("");
            boolean bl = true;

            for(String str : arr){
                answer += bl ? str.toUpperCase() : str;
                bl = str.equals(" ") ? true : false;
            }
            return answer;
    }
}