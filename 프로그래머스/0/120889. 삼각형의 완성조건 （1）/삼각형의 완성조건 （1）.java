import java.util.Arrays;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        return answer = sides[2] < sides[0] + sides[1] ? 1 : 2;
    }
}