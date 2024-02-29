import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<String>();

        for (int i=0; i<s.length(); i++){
            String str = String.valueOf(s.charAt(i));
            if(stack.empty()){
                stack.push(str);
            }else{
                String strPeek = stack.peek();
                if(strPeek.equals("(") && str.equals(")")){
                    stack.pop();
                }else{
                    stack.push(str);
                }
            }
        }
        return stack.empty();
    }
}