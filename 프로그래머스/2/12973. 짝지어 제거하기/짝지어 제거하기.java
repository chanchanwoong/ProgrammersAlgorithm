import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 문자가 stack peek 같은 경우, stack pop
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            
            // 문자가 다른 경우, stack push
            else stack.push(c);
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}