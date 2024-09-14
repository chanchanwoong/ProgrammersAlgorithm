import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input1 = br.readLine();
        String input2 = br.readLine();

        dp = new int[input1.length() + 1][input2.length() + 1];

        // DP 테이블 채우기
        for (int i = 0; i < input1.length(); i++) {
            char c1 = input1.charAt(i);
            
            for (int j = 0; j < input2.length(); j++) {
                char c2 = input2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        bw.write(dp[input1.length()][input2.length()] + "\n");

        if(dp[input1.length()][input2.length()] != 0) { 
            // LCS 문자열 복원
            StringBuilder lcs = new StringBuilder();
            int i = input1.length();
            int j = input2.length();
    
            // dp 테이블을 역추적하여 LCS 문자열 구성
            while (i > 0 && j > 0) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    lcs.append(input1.charAt(i - 1));  // 문자를 LCS에 추가
                    i--;
                    j--;
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;  // 위쪽으로 이동
                } else {
                    j--;  // 왼쪽으로 이동
                }
            }

            // LCS는 뒤에서부터 쌓였으므로 reverse()로 뒤집음
            bw.write(lcs.reverse().toString() + "");
        }
    
        bw.flush();
        bw.close();
        br.close();
    }
}
