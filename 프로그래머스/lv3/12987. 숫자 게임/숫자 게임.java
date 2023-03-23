import java.util.Arrays;

class Solution{
    
    public int solution(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);

            int aPoint = 0;
            int bPoint = 0;
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[aPoint] > B[bPoint]) {
                    bPoint++;
                } else if (A[aPoint] == B[bPoint]) {
                    bPoint++;
                } else {
                    aPoint++;
                    bPoint++;
                    result++;
                }
            }
            return result;
        }
    
}
