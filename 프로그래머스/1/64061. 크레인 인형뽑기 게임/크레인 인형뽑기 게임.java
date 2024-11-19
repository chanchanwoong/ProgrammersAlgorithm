import java.util.*;

class Solution {
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int move : moves) {
            int item = 0;

            // 해당 열에서 가장 위에 있는 인형 찾기
            for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
                if (board[rowIndex][move - 1] != 0) {
                    item = board[rowIndex][move - 1];
                    board[rowIndex][move - 1] = 0; // 인형을 뽑았으므로 해당 칸을 0으로 갱신
                    break;
                }
            }
            
            // 인형이 없다면 다음 move 진행
            if (item == 0) continue;
            
            // stack 내부의 인형과 비교 처리
            if (item == stack.peek()) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(item);
            }
        }
        
        return answer;
    }
}