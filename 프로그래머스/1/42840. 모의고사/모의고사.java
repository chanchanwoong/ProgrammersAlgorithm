import java.util.*;
class Solution {
    	static int[] answer1 = { 1, 2, 3, 4, 5 }; // 5개 반복
	static int[] answer2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8개 반복
	static int[] answer3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10개 반복
	static int[] scores = { 0, 0, 0 };

    	public static List<Integer> solution(int[] answers) {
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == answer1[i % 5])
				scores[0]++;
			if (answers[i] == answer2[i % 8])
				scores[1]++;
			if (answers[i] == answer3[i % 10])
				scores[2]++;
		}

		// 최댓값 점수 구하기
		int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

		// 리스트 객체 만들기
		List<Integer> list = new ArrayList<>();

		// 리스트 많이 맞춘 사람 넣기
		for (int i = 0; i < 3; i++) {
			if (max == scores[i]) {
				list.add(i + 1);
			}
		}
		return list;
    }
}