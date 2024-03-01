import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> f = new ArrayList<>();
        f.add(0);
        f.add(1);

        for(int i=2; i<=n; i++){
            int value = (f.get(i-2) + f.get(i-1)) % 1234567;
            f.add(value);
        }
        answer = f.get(n);
        return answer;
    }
}