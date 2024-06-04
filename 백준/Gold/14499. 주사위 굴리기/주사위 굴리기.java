import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int x, y;
    static int k;
    static int[][] map;
    static int[] dice = new int[7]; // 7로 잡은 이유는 인덱스 편하게 하기 위해서

    // 1 동쪽, 2 서쪽, 3 북쪽, 4 남쪽
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++) {
            int d = Integer.parseInt(st.nextToken());
            move(d);
        }

    }

    static void move(int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        // 이동할 칸이 없으면 가만히 있어야 하고 출력도 하면 안된다.
        if(nx < 0 || ny < 0 || nx > m-1 || ny > n-1) return;

        // 주사위 갱신
        roll(d, nx, ny);
        x = nx;
        y = ny;
    }

    static void roll(int d, int x, int y) {
        // dice[3]가 윗면이라고 잡고 진행
        int tmp = dice[3];

        // 구르는 방향에 따른 주사위 상태 변화
        if (d == 1) {
            dice[3] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[2];
            dice[2] = tmp;
        } else if (d == 2) {
            dice[3] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[4];
            dice[4] = tmp;
        } else if (d == 3) {
            dice[3] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[1];
            dice[1] = tmp;
        } else if (d == 4) {
            dice[3] = dice[1];
            dice[1] = dice[6];
            dice[6] = dice[5];
            dice[5] = tmp;
        }

        // 주사위 위치의 지도 값이 0인 경우, 주사위의 값을 복사해온다.
        if(map[y][x] == 0) map[y][x] = dice[6];

        // 0이 아닌 경우, 주사위에 값을 복사하고 지도의 값은 0이 된다.
        else {
            dice[6] = map[y][x];
            map[y][x] = 0;
        }

        // 주사위 윗면 출력
        System.out.println(dice[3]);
    }
}
