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
        for(int i = 0; i < N; i++) s.add(br.readLine());

        // 입력된 단어 검사
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if(s.contains(input)) answer++;
        }        
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        br.close();
        bw.close();
    }
}