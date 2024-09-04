import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(factorial(N)));
        bw.flush();

        br.close();
        bw.close();
    }

    // 팩토리얼 메서드
    // 점화식 : factorial(n) = n * factorial(n - 1)
    // 기저식 : factorial(0) = 1
    private static int factorial(int n) {
        if(n == 0) return 1;
        return n * factorial(n - 1);
    }
}