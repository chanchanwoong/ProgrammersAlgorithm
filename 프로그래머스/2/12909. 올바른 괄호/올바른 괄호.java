import java.util.*;

class Solution {
    
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            
            if (tmp == '(') stack.push('(');
            else if (tmp == ')' && stack.isEmpty()) return false;
            else if (tmp == ')' && (stack.peek() != '(')) return false;
            else if (tmp == ')' && (stack.peek() == '(')) stack.pop();
        }
        
        return stack.isEmpty();
    }
}