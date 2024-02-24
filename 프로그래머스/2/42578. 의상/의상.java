import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
		int answer = 1;

		HashMap<String, Integer> map = new HashMap<>();

		for (String[] clothesArr : clothes) {
//			System.out.println(clothesArr[1] + " " + clothesArr[0]);
			map.put(clothesArr[1], map.getOrDefault(clothesArr[1], 0) + 1);
		}

		// 입지 않는 경우를 추가하여 모든 조합 계산하기
		Set set = map.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			answer *= (int)e.getValue()+1; 
		}
		return answer-1;
    }
}