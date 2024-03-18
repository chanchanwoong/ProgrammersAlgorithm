import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int w;
    static int l;
    // weight는 선입선출 개념으로 Queue 써볼려고 함.
    static Queue<Integer> weight = new LinkedList<>();
    static int time = 0;
    static int[] bridge;
    static int sum = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n, w, l 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        // 다리 길이만큼 배열 할당
        bridge = new int[w];

        // n개 트럭 무게 입력
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            weight.offer(Integer.parseInt(st.nextToken()));
        }


        solution();
    }
    public static void solution(){
        // bridge를 건넌 트럭의 수
        int count = 0;

        // 모든 트럭이 bridge를 건널 때 까지 진행
        while(count < n) {
            time++;

            // bridge 끝에 트럭이 있으면 count++ 하고 트럭의 무게 뺸다.
            if(bridge[w-1] > 0) {
                count++;
                sum -= bridge[w - 1];
            }

            // bridge에 트럭 한 칸씩 이동
            for(int i=w-1; i>0; i--){
                bridge[i] = bridge[i-1];
            }
            // 일단 0으로 초기화
            bridge[0] = 0;

            // bright의 무게들과 weight 큐의 나갈 값 합이 최대하중 l 이하여야 대기 트럭 들어간다.
            if(!weight.isEmpty() && sum + weight.peek() <= l){
                int nextTruck = weight.poll();
                bridge[0] = nextTruck;
                sum += nextTruck;
            }
        }
        System.out.println(time);
    }
}
