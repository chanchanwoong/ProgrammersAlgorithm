import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    static int area = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        // map 입력
        for (int j=0; j<n; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<m; i++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        // map 요소에 검사 중 확인하지 않은 그림의 경우 bfs를 통해 넓이 확인
        for (int j=0; j<n; j++) {
            for (int i=0; i<m; i++) {
                if (map[j][i] == 1 && !visited[j][i]) {
                    visited[j][i] = true;
                    cnt++;
                    area = Math.max(area, bfs(j, i));
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.newLine();
        bw.write(String.valueOf(area));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int y, int x) {
        int localArea = 1;
        Queue<P> q = new LinkedList<>();
        P p = new P(x, y);
        q.add(p);

        while (!q.isEmpty()) {
            P curP = q.poll();
            int curX = curP.getX();
            int curY = curP.getY();

            for(int k=0; k<4; k++) {
                int nextX = curX + dx[k];
                int nextY = curY + dy[k];

                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n) {
                    if (map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        q.add(new P(nextX, nextY));
                        localArea++;
                    }
                }
            }
        }
        return localArea;
    }
}
class P {
    private int x, y;

    public P(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}

