import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 동적 계획법을 이용한 조합 계산
        int result = getCombination(n, k);
        bw.write(String.valueOf(result));
        bw.flush();
        
        br.close();
        bw.close();
    }

    // 동적 계획법을 이용한 조합 계산 메서드
    private static int getCombination(int n, int k) {
        // dp 테이블 초기화
        int[][] dp = new int[n + 1][k + 1];

        // 테이블 채우기
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                // 기본 조건
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    // 점화식
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }
}
