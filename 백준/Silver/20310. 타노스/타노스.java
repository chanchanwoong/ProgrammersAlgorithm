import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        // "0"의 개수 x, "1"의 개수 y
        int x = 0, y = 0;

        for (char c : str.toCharArray()) {
            if (c == '0') x++;
            else y++;
        }

        System.out.println("0".repeat(x/2) + "1".repeat(y/2));
    }
}
