import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Set<String> s = new HashSet<>();
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        // 집합 S 저장
        storeSetS(br, N);

        // 입력된 단어 검사
        checkInputString(br, M);
        
        bw.write(String.valueOf(answer));
        // bw.write(answer + "");
        bw.flush();
        
        br.close();
        bw.close();
    }

    // 집합 S 저장 메서드
    private static void storeSetS(BufferedReader br, int N) throws IOException{
        for(int i = 0; i < N; i++) {
            s.add(br.readLine());
        }
    }

    // 입력 String 검사 메서드
    private static void checkInputString(BufferedReader br, int M) throws IOException {
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if(s.contains(input)) answer++;
        }
    }
}