import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer;
        // n이 홀수냐, 짝수냐에 따라 answer의 길이 결정
        if(n%2==0){
            answer = new int[n/2];
        }else{
            answer = new int[n/2 + 1];
        }
        
        int index = 0;
        for(int i=1;i<=n;i++){
            if(i%2==1){
                answer[index++] = i;
            }
        }
        
        return answer;
    }
}