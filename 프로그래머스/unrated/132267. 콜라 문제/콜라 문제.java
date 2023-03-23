class Solution {
	public int solution(int a, int b, int n) {
		return recur(a, b, n, 0);
	}
	
	public int recur(int a, int b, int n, int answer) {
		if (n<a) {
			return answer;
		}
	
		int bottle = (n/a) * b;	
		n = (n%a) + bottle;	
		return recur(a, b, n, answer + bottle);
	}
}