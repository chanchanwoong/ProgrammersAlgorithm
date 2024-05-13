import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] roma = {1, 5, 10, 50};
    static Set<Integer> set = new HashSet<>();
    static int n;

    public static void solution(int idx, int sum, int cnt) {
        // 기저 조건
        if (cnt == n) {
            set.add(sum);
            return;
        }

        // 현재 인덱스부터 나머지 인덱스에 대해 모든 조합을 생성
        for (int i = idx; i < 4; i++) {
            solution(i, sum + roma[i], cnt + 1);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();

        solution(0, 0, 0);
        System.out.println(set.size());
    }
}
