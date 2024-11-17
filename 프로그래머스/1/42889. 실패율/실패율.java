import java.util.*;

class Solution {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> failureRate = new HashMap<>();
        
        int playerNumber = stages.length;
        int curStage = 1;

        for (int i = 0; i < N; i++) {
            int curStagePlayer = 0;

            // 현재 스테이지에 도달한 플레이어 수 계산
            for (int stage : stages) {
                if (curStage == stage) {
                    curStagePlayer++;
                }
            }

            // 실패율 계산
            if (playerNumber != 0) {
                failureRate.put(curStage, (double) curStagePlayer / playerNumber);
            } else {
                failureRate.put(curStage, 0.0);
            }

            playerNumber -= curStagePlayer;
            curStage++;
        }

        // 실패율 기준 내림차순으로 정렬
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(failureRate.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // 실패율 내림차순 정렬

        // 정렬된 결과로 answer 배열 채우기
        int index = 0;
        for (Map.Entry<Integer, Double> entry : entryList) {
            answer[index++] = entry.getKey();
        }

        return answer;
    }
}
