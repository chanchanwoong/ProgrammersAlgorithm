import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static String dirs;
    static int[][] map = new int[11][11];
    static boolean[][][] visit = new boolean[11][11][4];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};
    static int x = 5, y = 5;

    public static int solution(String dirs) {
        int answer = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int dirIndex = 0;
            if (dir == 'U') {
                dirIndex = 0;
            } else if (dir == 'R') {
                dirIndex = 1;
            } else if (dir == 'D') {
                dirIndex = 2;
            } else if (dir == 'L') {
                dirIndex = 3;
            }
            int nx = x + dx[dirIndex];
            int ny = y + dy[dirIndex];

            // 영역 확인
            if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) {
                continue;
            }

            // 방문 확인
            if (!visit[nx][ny][dirIndex]) {
                visit[nx][ny][dirIndex] = true;

                dirIndex = (dirIndex % 2 == 0) ? 2 - dirIndex : 4 - dirIndex;
                // 반대 방향도 확인
                visit[x][y][dirIndex] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dirs = br.readLine();
        int result = solution(dirs);
        System.out.println(result);
    }
}
