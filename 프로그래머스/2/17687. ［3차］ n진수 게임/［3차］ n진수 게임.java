class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";

        // 1. 전체 문자열을 str로 저장
        for (int i=0; i<=m*t; i++){
            String numToString = Integer.toString(i, n);
            str += numToString;
        }
        // 2. 필요한 문자 추출
        for (int i=0; i<t; i++){
            char c = str.charAt(p - 1 + i * m);
            answer += String.valueOf(c);
        }
        return answer.toUpperCase();
    }
}