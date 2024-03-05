import java.util.*;

class Solution {
    public int solution(int[] order) {
       int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<order.length+1; i++){
            // if(order[answer] == i){
            //     answer++;
            // }else{
            //     stack.push(i);
            // }
            stack.push(i);
            while(!stack.isEmpty() && order[answer] == stack.peek()){
                answer++;
                stack.pop();
            }
        }
        return answer;
    }
}