import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 시작점은 왼쪽 맨 밑(R-1, 0), 끝점은 오른쪽 맨 위(0, C-1)
        visited[R-1][0] = true;
        dfs(R-1, 0, 1);

        System.out.println(count);
    }

    public static void dfs(int x, int y, int dist) {
        // 목표 지점에 도달했을 때 거리 확인
        if (x == 0 && y == C-1) {
            if (dist == K) {
                count++;
            }
            return;
        }

        // 상, 우, 하, 좌 네 방향으로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 가능한 구간 필터링
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != 'T' && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, dist + 1);
                visited[nx][ny] = false;
            }
        }
    }

    // 위치를 저장할 객체
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
