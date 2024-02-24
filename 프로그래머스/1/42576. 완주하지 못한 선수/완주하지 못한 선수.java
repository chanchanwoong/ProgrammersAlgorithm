import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap();

		// HashMap에 participant마다 1씩 넣어주기
		for (String str : participant) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}


		// HashMap에서 completion 값 빼기
		for (String str : completion) {
			map.put(str, map.get(str) - 1);
		}

		String answer = "";
		for (String str : map.keySet()) {
			if(map.get(str) == 1){
                answer = str;
                break;
            }
		}
		return answer;

    }
}