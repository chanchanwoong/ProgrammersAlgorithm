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

        // 최장 길이 공통 수열의 길이 점화식
        for(int i = 0; i < input1.length(); i++) {
            char c1 = input1.charAt(i);
            
            for(int j = 0; j < input2.length(); j++) {    
                char c2 = input2.charAt(j);
                dp[i + 1][j + 1] = c1 == c2 ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        
        // 최장 길이 공통 수열의 길이
        bw.write(dp[input1.length()][input2.length()] + "");
        
        bw.flush();
        bw.close();
        br.close();
    }
}