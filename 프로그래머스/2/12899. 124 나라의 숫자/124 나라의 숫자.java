class Solution {
    public String solution(int n){
        String[] numbers = {"4", "1", "2"};
        String answer = "";
        while(n > 0) {
            int t = n % 3;
            n /= 3;

            if(t == 0) n--;
            answer = numbers[t] + answer;
        }
        return answer;
    }
}