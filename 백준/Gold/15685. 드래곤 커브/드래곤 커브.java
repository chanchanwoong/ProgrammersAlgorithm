import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void dragonCurve(int x, int y, int d, int g) {
        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(d);

        // 초기 0세대 끝 점 표시
        map[x][y] = true;
        int curX = x + dx[d];
        int curY = y + dy[d];
        map[curX][curY] = true;


        // 세대 만큼 dragonCurve 생성
        for (int i = 0; i < g; i++) {
            int size = directions.size();
            for (int j = size - 1; j >= 0; j--) {
                int newD = (directions.get(j) + 1) % 4; // 90도 회전
                curX += dx[newD];
                curY += dy[newD];
                map[curX][curY] = true;

                directions.add(newD);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(x, y, d, g);
        }

        // 1×1 크기의 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수 확인
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
