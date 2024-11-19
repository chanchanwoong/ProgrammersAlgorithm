import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        // 문자열 회전 및 검사
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s, map)) answer++;
            
            // 문자열 회전
            s = s.substring(1) + s.charAt(0);
        }
        
        return answer;
    }
    
    // 괄호 문자열 검사
    private boolean isValid(String str, Map<Character, Character> map) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : str.toCharArray()) {
            
            // 열린 괄호 처리
            if (map.containsValue(c)) stack.push(c);
            
            // 닫힌 괄호 처리
            else if (map.containsKey(c)){
                if (stack.isEmpty() || stack.pop() != map.get(c)) return false;  
            }
        }
        
        return stack.isEmpty();
    }
}