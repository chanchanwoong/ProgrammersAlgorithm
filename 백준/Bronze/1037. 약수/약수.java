import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> divisorList = new ArrayList<>();
        
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            divisorList.add(Integer.parseInt(st.nextToken()));
        }
        
        bw.write(String.valueOf(Collections.max(divisorList) * Collections.min(divisorList)));
        bw.flush();
    }
}