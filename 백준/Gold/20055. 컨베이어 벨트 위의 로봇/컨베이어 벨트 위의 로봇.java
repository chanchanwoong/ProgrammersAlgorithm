import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] durability;  // 내구도를 저장하는 배열
    static boolean[] robot;   // 로봇의 위치를 저장하는 배열
    static int n, k;

    // 컨베이어 벨트를 회전시키는 함수
    public static void rotate() {
        int lastDurability = durability[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            durability[i] = durability[i - 1];
        }
        durability[0] = lastDurability;

        for (int i = n - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[n - 1] = false; // 로봇이 내려가는 위치는 항상 비어 있어야 함
    }

    // 로봇을 이동시키는 함수
    public static void moveRobots() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && durability[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                durability[i + 1]--;
            }
        }
        robot[n - 1] = false; // 로봇이 내려가는 위치는 항상 비어 있어야 함
    }

    // 새로운 로봇을 올리는 함수
    public static void placeRobot() {
        if (durability[0] > 0) {
            robot[0] = true;
            durability[0]--;
        }
    }

    // 내구도가 0인 칸의 개수를 확인하는 함수
    public static boolean checkDurability() {
        int count = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (durability[i] == 0) {
                count++;
            }
        }
        return count >= k;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        durability = new int[2 * n];
        robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;

        while (true) {
            time++;
            rotate();       // 컨베이어 벨트 회전
            moveRobots();   // 로봇 이동
            placeRobot();   // 새로운 로봇 올리기
            if (checkDurability()) { // 내구도 검사
                break;
            }
        }
        System.out.println(time);
    }
}
