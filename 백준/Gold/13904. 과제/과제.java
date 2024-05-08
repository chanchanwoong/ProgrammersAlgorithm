import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] schedule = new int[1001];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 가치를 기준으로 내림차순 정렬
        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
//        System.out.println(Arrays.deepToString(arr));

        // arr 배열을 돌면서 스케줄 배열에다가 집어 넣는다.
        for(int i=0; i<n; i++) {
            int value = arr[i][1];
            int day = arr[i][0] - 1;

            // 스케줄 배열에 빈 값이면 집어넣는다.
            // 빈 곳에 넣을 때 까지 반복
            while(day>=0) {
                if (schedule[day] == 0) {
                    schedule[day] = value;
                break;
}
                // 이미 있는 경우에는 가치 비교를 해줘서 큰 값이 유지되고 작은 값은 앞으로 당겨져야 한다.
                else {
                    int bigValue = Math.max(schedule[day], value);
                    int smallValue = Math.min(schedule[day], value);
                    schedule[day] = bigValue;
                    value = smallValue;
                    day--;
                }
            }
        }
        // 스케줄 배열을 전부 더해서 최종 값 도출
        int sum = 0;
        for (int i : schedule) {
            sum += i;
        }
        System.out.println(sum);
    }
}