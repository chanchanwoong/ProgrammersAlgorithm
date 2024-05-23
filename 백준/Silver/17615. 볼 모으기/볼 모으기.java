import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] balls = br.readLine().toCharArray();

        int totalRed = 0, totalBlue = 0;
        for (char ball : balls) {
            if (ball == 'R') totalRed++;
            else totalBlue++;
        }

        int leftRed = 0, rightRed = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] == 'R') leftRed++;
            else break;
        }
        
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] == 'R') rightRed++;
            else break;
        }

        int leftBlue = 0, rightBlue = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] == 'B') leftBlue++;
            else break;
        }
        
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] == 'B') rightBlue++;
            else break;
        }

        int minMoves = Math.min(Math.min(totalRed - leftRed, totalRed - rightRed),
                                Math.min(totalBlue - leftBlue, totalBlue - rightBlue));

        System.out.println(minMoves);
    }
}