import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int M, N, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[M][N];
            visited = new boolean[M][N];
            
            // 테스트 별 배추 위치 지정
            getMap(st, br);

            int answer = 0;

            // bfs 실행
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
    
                    // 배추있는 곳만 bfs 진행
                    if(map[i][j] && !visited[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }
            
            bw.write(answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    // 배추 위치 지정 메서드
    private static void getMap(StringTokenizer st, BufferedReader br) throws IOException {
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = true;    
        }
    }

    // bfs
    private static void bfs(int x, int y) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            int curX = curPoint[0];
            int curY = curPoint[1];

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 다음 위치가 map을 벗어난 경우
                if(!(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N)) continue;

                // 다음 위치에 배추가 없는 경우
                if(!(map[nextX][nextY])) continue;

                // 방문하지 않은 경우 Queue 삽입
                if(!visited[nextX][nextY]) {
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}