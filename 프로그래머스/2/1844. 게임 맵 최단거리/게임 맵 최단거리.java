import java.util.*;

class Solution {
    
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    // 노드 생성
    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] maps) {        
        // 세로(N), 가로(M) 지정
        int N = maps.length;
        int M = maps[0].length;
        
        // 최단 거리를 저장할 배열 생성
        int[][] dist = new int[N][M];
        
        Queue<Node> queue = new LinkedList<>();
        
        // 초기 위치 노드 삽입
        queue.offer(new Node(0, 0));
        dist[0][0] = 1;
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            // 이동 가능한 방향 확인
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                
                if (maps[nr][nc] == 0) {
                    continue;
                }
                
                if (dist[nr][nc] == 0) {
                    queue.offer(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        
        // 목적지까지 최단 거리 반환, 목적지 도달 못 하면 -1 반환
        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }
}