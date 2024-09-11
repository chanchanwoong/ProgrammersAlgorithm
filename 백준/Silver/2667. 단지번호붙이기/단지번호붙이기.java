import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static List<Integer> answer = new ArrayList<>();
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // map 내부 탐색 조건
                if(map[i][j] == 1 && !visited[i][j]) {  
                    bfs(i, j);
                }
            }
        }
        
        // 문제 요구사항 처리
        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        for(int temp : answer) bw.write(temp + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        // 최초 위치와 단지 넓이
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        int curArea = 1;
        
        while(!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            int curX = curPoint[0];
            int curY = curPoint[1];

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N
                  && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                    curArea++;
                  }
            }
        }

        // 단지 탐색 끝
        answer.add(curArea);
    }
}