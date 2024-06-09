import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] currentOrder;
    static int[] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        currentOrder = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) currentOrder[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (currentOrder[i] > currentOrder[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            // LIS 최장 길이 저장
            max = Math.max(max, dp[i]);
        }
        // 전체 아이들 수 - LIS 최장 길이 = 최소 이동 수
        System.out.println(n - max);
    }
}
