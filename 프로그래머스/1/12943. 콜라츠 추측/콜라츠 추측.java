class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n != 1 && answer < 400) {
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            answer++;
        }

        return (n == 1) ? answer : -1; 
    }
}