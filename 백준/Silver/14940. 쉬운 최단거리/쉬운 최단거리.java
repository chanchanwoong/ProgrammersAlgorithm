import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] result;
    static boolean[][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        isVisited = new boolean[n][m];

        // 목표지점을 시작 위치로 지정
        int startX = -1;
        int startY = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                // result 영역을 미리 할당
                if (num == 0) result[i][j] = 0;
                else if (num == 2) {
                    startX = i;
                    startY = j;
                    result[i][j] = 0;
                }
                else result[i][j] = -1;
            }
        }
        isVisited[startX][startY] = true;
        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
//        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            Point curPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dx[i];
                int nextY = curPoint.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (map[nextX][nextY] == 0) continue;
                if (isVisited[nextX][nextY]) continue;

                q.add(new Point(nextX, nextY));
                // 새로 진입한 영역은 기존 영역에 1칸 더 갔음
                result[nextX][nextY] = result[curPoint.x][curPoint.y] + 1;
                isVisited[nextX][nextY] = true;

            }
        }
    }
}

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
