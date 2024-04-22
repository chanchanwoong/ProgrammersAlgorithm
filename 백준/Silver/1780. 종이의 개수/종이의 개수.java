import java.io.*;
import java.util.*;

public class Main {
    static int numberOfMinusOne = 0;
    static int numberOfZero = 0;
    static int numberOfPlusOne = 0;

    public static void solution(int[][] map, int size, int startX, int startY) {
        int item = map[startX][startY];
        boolean isSame = true;

        // 해당 구역이 모두 같은 값인지 확인
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (map[i][j] != item) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        // 해당 구역이 모두 같은 값이면 해당 값의 개수를 증가
        if (isSame) {
            if (item == -1) numberOfMinusOne++;
            else if (item == 0) numberOfZero++;
            else if (item == 1) numberOfPlusOne++;
        }
        // 같은 값이 아니면 9개로 분할하여 재귀 호출
        else {
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    solution(map, newSize, startX + i * newSize, startY + j * newSize);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(map, N, 0, 0);

        System.out.println(numberOfMinusOne);
        System.out.println(numberOfZero);
        System.out.println(numberOfPlusOne);
    }
}