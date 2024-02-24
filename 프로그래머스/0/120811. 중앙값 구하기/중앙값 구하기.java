import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int length = array.length;
        Arrays.sort(array);
        answer = array[length/2];
        return answer;
    }
}