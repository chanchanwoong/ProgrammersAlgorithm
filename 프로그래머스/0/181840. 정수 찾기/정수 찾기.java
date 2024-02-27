class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        for(int i=0; i<num_list.length; i++){
            answer += num_list[i] == n ? 1 : 0;
            if (answer == 1) return answer;
        }
        return answer;
    }
}