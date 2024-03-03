class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] memo = new int[land.length][4];

        // memo의 첫 행은 land 첫 행과 동일
        for(int i=0; i<4; i++){
            memo[0][i] = land[0][i];
        }

        // memo 두 번째 행부터 값 할당
        for(int i=1; i< land.length; i++){
            int max;

            // 해당 행 바로 전 행에서 가장 큰 값을 찾음
            // 현재 열은 max에 포함 못하도록 해야 한다.
            max = Math.max(Math.max(memo[i-1][1], memo[i-1][2]), memo[i-1][3]);
            memo[i][0] = land[i][0] + max;

            max = Math.max(Math.max(memo[i-1][0], memo[i-1][2]), memo[i-1][3]);
            memo[i][1] = land[i][1] + max;

            max = Math.max(Math.max(memo[i-1][0], memo[i-1][1]), memo[i-1][3]);
            memo[i][2] = land[i][2] + max;

            max = Math.max(Math.max(memo[i-1][0], memo[i-1][1]), memo[i-1][2]);
            memo[i][3] = land[i][3] + max;
        }

        answer = Math.max(Math.max(memo[land.length-1][0], memo[land.length-1][1]), Math.max(memo[land.length-1][2], memo[land.length-1][3]));

        return answer;
    }
}