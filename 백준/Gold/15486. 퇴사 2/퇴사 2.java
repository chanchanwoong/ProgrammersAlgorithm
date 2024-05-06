import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] timeArr = new int[n];
        int[] payArr = new int[n];
        int[] dp = new int[n+1];

        for (int i=0; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            timeArr[i] = Integer.parseInt(st.nextToken());
            payArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {
            // 현재 날짜에서 상담을 진행하면 날짜 안에 끝낼 수 있는 지 확인
            if(i + timeArr[i] <= n) {
                
                // 현재 날짜 + 상담 완료의 최대 수입 VS 오늘 이전까지 최대 수입 + 오늘 버는 수입
                dp[i+timeArr[i]] = Math.max(dp[i+timeArr[i]], dp[i] + payArr[i]);
            }
            
            // 상담 진행되는 중에도 0원이 아닌 이전의 최대 금액이 되야 한다.
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}
