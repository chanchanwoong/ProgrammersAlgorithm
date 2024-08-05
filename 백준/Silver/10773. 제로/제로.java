import java.util.*;
import java.io.*;

public class Main {
    static int k, sum;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                stack.pop();
                continue;
            }
            stack.add(input);
        }

        while(!stack.isEmpty()) sum += stack.pop();
        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}
