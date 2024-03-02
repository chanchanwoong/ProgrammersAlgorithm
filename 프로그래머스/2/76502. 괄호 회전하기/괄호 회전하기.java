import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        // s의 길이만큼 반복
        for(int i=0; i<s.length(); i++) {
            Stack<String> stack = new Stack<String>();

            for (int j = 0; j < s.length(); j++) {
                // stack이 빈 경우(처음인 문자인 경우)
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(s.charAt(j)));
                }
                // stack에 요소가 있는 경우
                else {
                    switch (stack.peek()) {
                        case "(":
                            if (String.valueOf(s.charAt(j)).equals(")")) {
                                stack.pop();
                            } else {
                                stack.push(String.valueOf(s.charAt(j)));
                            }
                            break;
                        case "{":
                            if (String.valueOf(s.charAt(j)).equals("}")) {
                                stack.pop();
                            } else {
                                stack.push(String.valueOf(s.charAt(j)));
                            }
                            break;
                        case "[":
                            if (String.valueOf(s.charAt(j)).equals("]")) {
                                stack.pop();
                            } else {
                                stack.push(String.valueOf(s.charAt(j)));
                            }
                            break;
                        default:
                            stack.push(String.valueOf(s.charAt(j)));
                    }
                }
            }
            // s 왼쪽으로 한칸 돌리기
            s = s.substring(1, s.length()) + s.charAt(0);

            // stack이 비었으면, answer++
            answer += stack.isEmpty() ? 1 : 0;
        }
        return answer;
    }
}