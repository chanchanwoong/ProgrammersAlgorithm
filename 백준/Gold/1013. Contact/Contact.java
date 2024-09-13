import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static final String PATTERN = "(100+1+|01)+";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        final int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String input = br.readLine();

            String result = input.matches(PATTERN) ? "YES" : "NO";
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
