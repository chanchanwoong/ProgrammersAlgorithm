import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        
        final int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String input1 = st.nextToken();
            String input2 = st.nextToken();

            if(set.contains(input1) || set.contains(input2)) {
                set.add(input1);
                set.add(input2);
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();

        br.close();
        bw.close();
    }
}