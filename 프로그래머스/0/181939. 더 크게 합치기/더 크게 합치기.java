class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String aToString = Integer.toString(a);
			String bToString = Integer.toString(b);
			
			answer = Integer.valueOf(aToString + bToString) > Integer.valueOf(bToString + aToString)? 
					Integer.valueOf(aToString + bToString) : Integer.valueOf(bToString + aToString);
		
        return answer;
    }
}