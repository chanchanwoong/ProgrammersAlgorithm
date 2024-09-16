import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());

        // 불가능한 경우
        if (N == 4 || N == 7) {
             bw.write(-1 + "");   
        }

        // 간단한 5의 배수인 경우
        else if (N % 5 == 0) {
            bw.write(N / 5 + "");
        }

        // 5로 나눈 나머지가 1 또는 3인 경우
        else if (N % 5 == 1 || N % 5 == 3) {
            bw.write((N / 5) + 1 + "");
        }

        // 5로 나눈 나머지가 2 또는 4인 경우
        else if (N % 5 == 2 || N % 5 == 4) {
            bw.write((N / 5) + 2 + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}