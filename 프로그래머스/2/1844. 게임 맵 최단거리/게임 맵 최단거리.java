import java.util.*;

class Solution {
    
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;
    
    // 노드 생성
    private static class Node {
        int r, c, dist;
        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {        
        // 세로(N), 가로(M) 지정
        int N = maps.length;
        int M = maps[0].length;
        int answer = 1;
        visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        
        // 초기 위치 노드 삽입
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            // 목표에 도달
            if (now.r == N - 1 && now.c == M - 1) {
                return now.dist;
            }
            
            // 이동 가능한 방향 확인
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                
                if (maps[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }
                
                // 방문 처리 및 다음 노드 추가
                queue.offer(new Node(nr, nc, now.dist + 1));
                visited[nr][nc] = true;
                
            }
        }
        
        return -1;
    }
}