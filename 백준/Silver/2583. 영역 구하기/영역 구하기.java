import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m, n;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] map;
    static boolean[][] visited;

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int area = 1;

        while(!q.isEmpty()) {
            int[] data = q.poll();
            int curX = data[0];
            int curY = data[1];

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        q.offer(new int[]{nextX, nextY});
                        area++;
                    }
                }
            }
        }
        return area;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    map[j][l] = 1;      // 벽 있는 곳
                }
            }
        }

        // 벽이 없고 방문하지 않은 곳에서 bfs를 통해 넓이 획득
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (map[i][j] == 0 && !visited[i][j]){
                    int area = bfs(i,j);
                    list.add(area);
                }
            }
        }

        // list 길이 오름차순 정렬
        Collections.sort(list);

        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
