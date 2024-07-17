import java.io.*;
import java.util.*;

public class Main {
    static final int FULL_SIZE = 100;
    static final int SIZE = 10;
    static int n;
    static int answer = 0;
    static boolean[][] map = new boolean[FULL_SIZE][FULL_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 입력 정사각형 채우기 및 answer 갱신
            fillArea(x, y);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void fillArea(int x, int y) {
        for (int i = x; i < x + SIZE; i++) {
            for (int j = y; j < y + SIZE; j++) {
                if(!map[i][j]) {
                    map[i][j] = true;
                    answer++;
                }
            }
        }
    }
}
