import java.io.*;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            Point point1 = new Point(st.nextToken(), st.nextToken(), st.nextToken());
            Point point2 = new Point(st.nextToken(), st.nextToken(), st.nextToken());
            solution(point1, point2, bw);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void solution(Point point1, Point point2, BufferedWriter bw) throws IOException {
        double distance = Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2)
                + Math.pow(point1.getY() - point2.getY(), 2));

        // 각 경우에 따른 결과 출력
        // 1. 중점이 같으면서 반지름 같은 경우
        if (point1.getX() == point2.getX() && point1.getY() == point2.getY() && point1.getR() == point2.getR()) {
            bw.write(String.valueOf(-1));
        }
        // 2. 두 원의 반지름 합 보다 중점 간 거리가 더 긴 경우
        else if (distance > point1.getR() + point2.getR()) {
            bw.write(String.valueOf(0));
        }
        // 3. 한 원이 다른 원 안에 포함되어 있지만 접점이 없는 경우
        else if (distance < Math.abs(point1.getR() - point2.getR())) {
            bw.write(String.valueOf(0));
        }
        // 4. 내접하는 경우
        else if (distance == Math.abs(point1.getR() - point2.getR())) {
            bw.write(String.valueOf(1));
        }
        // 5. 외접하는 경우
        else if (distance == point1.getR() + point2.getR()) {
            bw.write(String.valueOf(1));
        }
        // 6. 나머지 경우
        else {
            bw.write(String.valueOf(2));
        }
        bw.newLine(); // 각 결과를 새로운 줄에 출력하기 위해 줄바꿈 추가
    }
}

class Point {
    private int x, y, r;

    public Point(String x, String y, String r) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.r = Integer.parseInt(r);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getR() {
        return r;
    }
}
