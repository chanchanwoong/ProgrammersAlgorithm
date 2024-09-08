import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
        
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int answer = bfs();
        
        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        
        // 현재 x, y 좌표와 경로 길이
        int[] curPoint = {0, 0, 1};
        
        visited[0][0] = true;
        queue.add(curPoint);

        while(!queue.isEmpty()) {
            curPoint = queue.poll();
            int curX = curPoint[0];
            int curY = curPoint[1];
            int curDist = curPoint[2];

            // 기저조건
            if(curX == N - 1 && curY == M - 1) return curDist;
                        
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M 
                   && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY, curDist + 1});
                }
            }
        }
        
        return -1;
    }
}