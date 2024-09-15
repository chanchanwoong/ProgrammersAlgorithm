import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int T = Integer.parseInt(br.readLine());
        
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // dp 배열 채우기
        for(int i = 4; i < 11; i++) {
            
            // dp 점화식
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for(int t = 0; t < T; t++) {
            int input = Integer.parseInt(br.readLine());
            bw.write(dp[input] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}