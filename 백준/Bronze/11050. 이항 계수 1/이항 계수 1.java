import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        bw.write(String.valueOf(getCombination(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
        bw.flush();
        
        br.close();
        bw.close();
    }

    // 재귀 호출을 이용한 조합 수 메서드
    // 기저 조건 : nCk = nC0 = 0
    // 점화식 : nCk = n-1Cr-k + n-1Ck
    private static int getCombination(int n, int k) {
        // 기저조건
        if(n == k || k == 0) return 1;
        else return getCombination(n - 1, k - 1) + getCombination(n - 1, k);
    }
}