import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            checkVps();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void checkVps() throws IOException {
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                continue;
            }

            if (ch == ')') {
                if (stack.isEmpty()) {
                    bw.write("NO\n");
                    return;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("YES\n");
        } else {
            bw.write("NO\n");
        }
    }
}