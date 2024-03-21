import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    // 입력 숫자들
    static int[] arr;
    // 연산자 + 개수 -> - 개수 -> x 개수 -> / 개수
    static int[] oper = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int num, int idx) {
        if (idx == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (oper[i] > 0) {

                // 해당 연산자를 1 감소시킨다.
                oper[i]--;

                switch (i) {

                    case 0 : dfs(num + arr[idx], idx + 1); break;
                    case 1 : dfs(num - arr[idx], idx + 1); break;
                    case 2 : dfs(num * arr[idx], idx + 1); break;
                    case 3 : dfs(num / arr[idx], idx + 1); break;

                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                oper[i]++;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }
}
