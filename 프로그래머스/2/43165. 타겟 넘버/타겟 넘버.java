import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(numbers[0]);
        list.add(-1 * numbers[0]);

        for(int i=1; i<numbers.length; i++){
            // 잠시 담아둘 리스트
            ArrayList<Integer> tmpList = new ArrayList<>();
            int value = numbers[i];
            for(int j=0; j<list.size(); j++){
                tmpList.add(list.get(j) + value);
                tmpList.add(list.get(j) - value);
            }
            list = tmpList;
        }

        for(int i=0; i<list.size(); i++){
            answer += list.get(i) == target ? 1 : 0;
        }
        return answer;
    }
}