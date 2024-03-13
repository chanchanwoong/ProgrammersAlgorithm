
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();	// 유저의 수
        M = sc.nextInt();	// 친구 관계의 수

        arr= new int[N+1][N+1];

        //초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) arr[i][j]=INF;
            }
        }
        //관계 입력
        for(int i=0;i<M;i++) {
            int a= sc.nextInt();
            int b= sc.nextInt();
            arr[a][b]=arr[b][a]=1;
        }

        //플로이드-워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }


        int min = Integer.MAX_VALUE;
        int minIdx = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++)
                sum += arr[i][j];

            if (min > sum) {
                min = sum;
                minIdx = i;
            }
        }

        System.out.println(minIdx);
    }// main()
}
