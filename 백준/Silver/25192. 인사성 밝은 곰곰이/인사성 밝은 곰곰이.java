import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        int answer = 0;
        
        final int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String input = br.readLine();

            if(input.equals("ENTER")) {
                // 입장 전 채팅 또는 인사는 중복을 제거하여 곰곰티콘 사용으로 처리
                answer += set.size();
                
                // 처리 후 set 초기화
                set.clear();
            }else {
                set.add(input);
            }
        }

        // 마지막 set에 남은 데이터 처리
        answer += set.size();
        
        bw.write(String.valueOf(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}