import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<String, Integer> map = new HashMap<>();
        
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String input = br.readLine();

            if(input.length() >= M) {
                map.put(input, map.getOrDefault(input, 0) + 1);
            }   
            continue;
        }

        // 맵을 리스트로 변환
        List<String> words = new ArrayList<>(map.keySet());

        // 우선순위에 따른 정렬 (1. 빈도, 2. 길이, 3. 알파벳순)
        words.sort((word1, word2) -> {
            int freqCompare = map.get(word2) - map.get(word1);
            if (freqCompare != 0) {
                return freqCompare;
            }
            int lengthCompare = word2.length() - word1.length();
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return word1.compareTo(word2);
        });

        // 정렬된 결과 출력
        for (String word : words) {
            bw.write(word + "\n");
        }
        
        bw.flush();

        br.close();
        bw.close();
    }
}