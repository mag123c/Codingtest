class Solution {	
    
    public int[] solution(int[] answers) {
        int[] people = new int[3];
        int[] one = new int[] {1,2,3,4,5};
        int[] two = new int[] {2,1,2,3,2,4,2,5};
        int[] thr = new int[] {3,3,1,1,2,2,4,4,5,5};
        
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        while(idx!=answers.length) {
        	if(idx1==one.length) idx1 = 0;
        	if(idx2==two.length) idx2 = 0;
        	if(idx3==thr.length) idx3 = 0;
        	
        	if(answers[idx] == one[idx1]) people[0]++;
        	if(answers[idx] == two[idx2]) people[1]++;
        	if(answers[idx] == thr[idx3]) people[2]++;
        	idx++;
        	idx1++;
        	idx2++;
        	idx3++;
        }
        
        if(people[0] > people[1]) {
        	if(people[0] > people[2]) return new int[] {1};
        	else if(people[0] < people[2]) return new int[] {3};
        	else return new int[] {1,3};
        }
        else if(people[0] < people[1]) {
        	if(people[1] < people[2]) return new int[] {3};
        	else if(people[1] > people[2]) return new int[] {2};
        	else return new int[] {2,3};
        }
        else {
        	if(people[1] > people[2]) return new int[] {1,2};
        	else if(people[1] < people[2]) return new int[] {3};
        	else return new int[] {1,2,3};
        }        
    }
}