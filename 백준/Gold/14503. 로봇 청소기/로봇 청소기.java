import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int r, c;
    static int d;       // 방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map; // map -1 청소 한 곳, 0은 청소 안한 곳, 1은 벽
    static int cnt = 1;


    public static void dfs(int x, int y, int dir) {

        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 0) {
                    cnt++;
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4; //반대 방향으로 후진
        int bx = x + dx[d];
        int by = y + dy[d];
        if (bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            dfs(bx, by, dir); //후진이니까 바라보는 방향은 유지
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r, c, d);
        System.out.println(cnt);
    }
}
