import java.util.*;

class Solution {

    public static List<Integer> solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (pattern1[i % pattern1.length] == answer) scores[0]++;
            if (pattern2[i % pattern2.length] == answer) scores[1]++;
            if (pattern3[i % pattern3.length] == answer) scores[2]++;
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) list.add(i+1);
        }
        
    return list;
    }
}