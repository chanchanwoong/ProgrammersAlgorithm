import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] pattern = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-3,-9},{-1,-9,-3}};
    static int n;
    static int[] health = new int[3];
    static int[][][] dp = new int[61][61][61];
    static int minCnt = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        // health 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            health[i] = Integer.parseInt(st.nextToken());
        }
        dfs(health, 0);
        System.out.println(minCnt);
    }

    public static void dfs(int[] health, int cnt) {
        if(minCnt <= cnt) return;
        if(dp[health[0]][health[1]][health[2]] != 0 && dp[health[0]][health[1]][health[2]] <= cnt) return;
        dp[health[0]][health[1]][health[2]] = cnt;

        if(health[0] == 0 && health[1] == 0 && health[2] == 0) {
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        for(int i=0; i<6; i++) {
            dfs(new int[] {Math.max(health[0]+pattern[i][0], 0),Math.max(health[1]+pattern[i][1], 0),Math.max(health[2]+pattern[i][2], 0)},cnt+1);
        }
    }
}
