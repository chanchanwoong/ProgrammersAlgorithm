import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int n;
    static int[][] map = new int[20][20];

    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    // BFS 탐색 대상 클래스
    static class Point {
        int row, col, distance;
        Point (int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public static int solution(int srow, int scol){
        int time = 0;
        int size = 2, cnt = 2;

        // 최초 상어 위치를 Point 객체로 지정
        Point minPt = new Point(srow, scol, 0);

        do {
            Queue<Point> q = new LinkedList<>();
            boolean[][] visited = new boolean[20][20];

            // 최초 상어 위치 방문
            visited[minPt.row][minPt.col] = true;
            q.add(new Point(minPt.row, minPt.col, 0));
            minPt.distance = INF;

            while (!q.isEmpty()) {
                Point curr = q.poll();

                // 더 이상 물고기가 없음
                if (curr.distance > minPt.distance) break;


                // 물고기 사이즈 확인
                if (map[curr.row][curr.col] > size) continue;

                // 가장 가까운 물고기 찾기
                // 물고기 있는 지 확인하고, 자기보다 작은 지 확인
                if (map[curr.row][curr.col] != 0 && map[curr.row][curr.col] < size) {
                    if (curr.distance < minPt.distance) {
                        minPt = curr;
                    }
                    // 거리가 같은 물고기인 경우
                    else if (curr.distance == minPt.distance) {
                        // 더 위에 있는 물고기를 먼저 먹음
                        if (curr.row < minPt.row)
                            minPt = curr;
                        // 왼쪽에 있는 물고기를 먼저 먹음
                        else if (curr.row == minPt.row && curr.col < minPt.col)
                            minPt = curr;
                    }
                    continue;
                }


                for (int i = 0; i < 4; i++) {
                    int nRow = curr.row + dRow[i];
                    int nCol = curr.col + dCol[i];

                    if (nRow < 0 || nRow > n - 1 || nCol < 0 || nCol > n - 1) continue;
                    if (visited[nRow][nCol]) continue;
                    visited[nRow][nCol] = true;

                    q.add(new Point(nRow, nCol, curr.distance + 1));
                }
            }


            // 물고기를 찾은 경우
            if (minPt.distance != INF) {
                time += minPt.distance;
                cnt--;
                if (cnt == 0) {
                    size++;
                    cnt = size;
                }
                // 먹은 물고기를 없앰
                map[minPt.row][minPt.col] = 0;
            }
        } while(minPt.distance != INF);

        return time;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int srow = 0, scol = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                // 상어 위치 지정
                if (value == 9) {
                    srow = i;
                    scol = j;
                    // 상어가 있던 곳은 빈 공간으로 변환
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(solution(srow, scol));
    }
}
