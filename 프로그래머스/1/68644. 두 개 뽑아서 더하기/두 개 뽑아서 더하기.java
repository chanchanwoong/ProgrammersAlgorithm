import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        // 이중 반복문을 통해 정렬되지 않은 더한 배열 구하기
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}