class Solution {
    public int solution(int[][] sizes) {
		int answer = 0;
		int longerMax = 0;
		int shorterMax = 0;

		// 가로, 세로 쌍에서 긴 길이, 짧은 길이 쌍으로 변환
		for (int i = 0; i < sizes.length; i++) {
			int longer = Math.max(sizes[i][0], sizes[i][1]);
			int shorter = Math.min(sizes[i][0], sizes[i][1]);

			longerMax = longerMax < longer ? longer : longerMax;
			shorterMax = shorterMax < shorter ? shorter : shorterMax;
		}

		return answer = longerMax * shorterMax;
    }
}