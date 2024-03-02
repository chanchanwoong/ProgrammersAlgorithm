class Solution {
    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        while(n > 0){
            answer = numbers[n % 3] + answer;   // 첫 자릿수 부터 쭉 값 변환
            n = (n - 1) / 3;  // n 갱신
        }
        return answer;
    }
}