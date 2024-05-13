import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[31][31];

    // 조합 메서드
    public static int solution(int n, int r) {
        // solution(30, 15)가 155117520 라서 int 로 배열 잡음
//        int[][] dp = new int[31][31];

        if(dp[n][r] != 0 ) return dp[n][r];

        if (n == r || r == 0) return dp[n][r] = 1;

        return dp[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // m개 중에서 n개 선택
            System.out.println(solution(m, n));
        }
        br.close();
    }
}
