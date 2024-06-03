import java.util.*;
import java.io.*;

public class Main {
    static int n, l;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로 확인
        checkRowWay();
        // 세로 확인
        checkColWay();

        System.out.println(answer);
    }

    public static void checkRowWay() {
        for (int i = 0; i < n; i++) {
            if (canGo(map[i])) {
                answer++;
            }
        }
    }

    public static void checkColWay() {
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = map[j][i];
            }
            if (canGo(col)) {
                answer++;
            }
        }
    }

    public static boolean canGo(int[] line) {
        boolean[] used = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            if (line[i] == line[i + 1]) {
                continue; // 높이가 같으면 계속 진행
            }

            if (line[i] + 1 == line[i + 1]) { // 올라가는 경사로
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || line[i] != line[i - j] || used[i - j]) {
                        return false; // 경사로를 놓을 수 없는 경우
                    }
                }
                for (int j = 0; j < l; j++) {
                    used[i - j] = true;
                }
            } else if (line[i] - 1 == line[i + 1]) { // 내려가는 경사로
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || line[i + 1] != line[i + j] || used[i + j]) {
                        return false; // 경사로를 놓을 수 없는 경우
                    }
                }
                for (int j = 1; j <= l; j++) {
                    used[i + j] = true;
                }
            } else {
                return false; // 높이 차이가 1이 아닌 경우
            }
        }
        return true;
    }
}
