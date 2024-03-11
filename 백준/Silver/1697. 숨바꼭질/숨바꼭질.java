import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String input = br.readLine();

        int location1 = Integer.parseInt(input.split(" ")[0]);
        int location2 = Integer.parseInt(input.split(" ")[1]);

        System.out.println(solution(location1, location2));
    }
    public static int solution(int start, int end) {
        if (start == end) return 0;

        int[] visited = new int[100001]; // 방문 기록 및 시간 기록
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1; // 시작 위치 방문 처리

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 세 가지 경우 탐색: 현재 위치 -1, 현재 위치 +1, 현재 위치 *2
            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                // 범위 체크 및 방문 여부 확인
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);

                    if (next == end) {
                        return visited[next] - 1; // 처음 위치를 1로 표시했기 때문에 -1 반환
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우 (이론상 발생하지 않음)
    }
}
