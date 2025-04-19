class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       int[] temp = new int[100];  // 최대 작업 갯수
        int day = 0; // temp에 활용할 day

        // 몇일 만에 몇개가 배포되는지.
        for(int i=0; i<progresses.length; i++){
            while(progresses[i] + (speeds[i] * day) < 100){
                day++;
            }
            temp[day]++;
        }

        // temp 배열의 size
        int count = 0;        
        for(int n : temp){
            if(n != 0){
                count ++; 
            }
        }

        int[] answer = new int[count];

        count = 0; 
        for(int n : temp){
            if(n != 0){
                answer[count++] = n; 
            }
        }


        return answer;
    }
}