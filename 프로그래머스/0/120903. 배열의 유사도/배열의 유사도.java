class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        for (String str1 : s1){
            for (String str2 : s2){
                answer += str1.equals(str2) ? 1 : 0;   
            }
        }
        return answer;
    }
}