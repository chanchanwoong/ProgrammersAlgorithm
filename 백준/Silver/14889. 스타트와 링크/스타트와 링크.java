import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int Min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        combi(N/2, 0, visited);
        System.out.println(Min);
    }

    static void combi(int toChoose, int startIdx, boolean[] visited) {
        // 다 뽑은 경우
        if(toChoose == 0){
            int sumTeam1 = 0;
            int sumTeam2 = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i]==visited[j]){
                        // team1의 총 점수
                        if(visited[i]){
                            sumTeam1 += map[i][j];
                        }
                        // team2의 총 점수
                        else{
                            sumTeam2 += map[i][j];
                        }
                    }
                }
            }
            Min = Math.min(Min, Math.abs(sumTeam2 - sumTeam1));

            return;
        }

        for(int i=startIdx; i<N; i++) {
            visited[i] = true;
            combi(toChoose-1, i+1, visited);
            visited[i] = false;
        }
    }
}