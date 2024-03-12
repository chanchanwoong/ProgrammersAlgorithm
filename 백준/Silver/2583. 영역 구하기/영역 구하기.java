import java.util.*;

public class Main {
    static boolean[][] visited;
    // 동서남북 이동할 경로
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int m;
    static int n;
    static int[][] map;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();
        map = new int[m][n];
        visited = new boolean[m][n];

        // 지나간 곳 1로 채우기
        for(int i=0; i<k; i++){
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();
            for(int y=ly; y<ry; y++){
                for(int x=lx; x<rx; x++){
                    map[y][x] = 1;
                }
            }
        }

        solution(m, n, k, map);
    }
    public static void solution(int m, int n, int k, int[][] map){
        int numberOfArea = 0;
        ArrayList<Integer> areaList = new ArrayList<>();

        // 뻉뺑 돌면서 안간 곳을 찾아야 한다.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // 방문하지 않았거나, 직사각형이 아닌 곳을 들려야 한다.
                if(!visited[i][j] && map[i][j] == 0){
                    // 넓이
                    int area = bfs(i, j);
                    areaList.add(area);
                    numberOfArea++;
                }
            }
        }
        System.out.println(numberOfArea);

        // 넓이 오름차순해서 출력
        Collections.sort(areaList);
        for(int i : areaList){
            System.out.print(i + " ");
        }
    }
    public static int bfs(int x, int y){
        // 영역 넓이
        int area = 1;
        // 좌표를 저장할 큐 생성
        Queue<int[]> q = new LinkedList<>();
        // 큐에 첫 시작할 영역 넣음
        q.offer(new int[] {x, y});
        // 첫 시작점 간 영역으로 바꿈
        visited[x][y] = true;

        // 큐가 빌 때 까지 진행한다.
        while(!q.isEmpty()){
            // 맨 처음 들어갔던 좌표 추출(첫 값 삭제)
            int[] coordinate = q.poll();
            int queueX = coordinate[0];
            int queueY = coordinate[1];

            // 동서남북으로 움직일 때, 계산
            for(int i=0; i<4; i++){
                int nextX = queueX + dx[i];
                int nextY = queueY + dy[i];

                // 이동 경로가 원점보다 커야하고,
                if(nextX >= 0 && nextY >= 0 && nextX < m && nextY < n ){
                    // 방문한 곳이면 안되고, 가로막히지 않은 곳이어야 한다.
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 0){
                        // 들린 곳은 방문했다고 표시
                        visited[nextX][nextY] = true;
                        // 현재 위치를 큐에 삽입
                        q.offer(new int[]{nextX, nextY});
                        area++;
                    }
                }

            }
        }
        return area;
    }
}
