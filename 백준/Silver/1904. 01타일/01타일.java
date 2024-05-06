import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // 초기 값
        int data1 = 1;
        int data2 = 2;
        int sum = 0;
        
        for (int i = 2; i< n; i++) {
            sum = (data1 + data2) % 15746;
            data1 = data2;
            data2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
}