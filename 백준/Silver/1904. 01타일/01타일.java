import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] memo;

    public static int solution(int size) {
        // 기저 조건: 타일을 다 채운 경우
        if (size == n) {
            return 1;
        }

        // 이미 계산한 값이 있다면 바로 반환
        if (memo[size] != 0) {
            return memo[size];
        }

        int result = 0;

        // 현재 단계의 타일에 1을 추가한 경우
        if (size + 1 <= n) {
            result += solution(size + 1) % 15746;
        }

        // 현재 단계의 타일에 00을 추가한 경우
        if (size + 2 <= n) {
            result += solution(size + 2) % 15746;
        }

        // 계산한 값을 메모이제이션
        memo[size] = result % 15746;
        return memo[size];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 메모이제이션을 위한 배열 초기화
        memo = new int[n + 1];

        // 결과 출력
        System.out.println(solution(0) % 15746);
    }
}
