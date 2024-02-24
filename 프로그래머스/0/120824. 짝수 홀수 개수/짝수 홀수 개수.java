class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        
        for(int i : num_list) {
			answer[0] += i % 2 == 0 ? 1 : 0;
			answer[1] += i % 2 != 0 ? 1 : 0;
			
		}
        return answer;
    }
}