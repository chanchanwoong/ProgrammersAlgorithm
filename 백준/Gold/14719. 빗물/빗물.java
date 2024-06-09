import java.util.*;
import java.io.*;

public class Main {
    static int h, w;
    static int[] heights;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        heights = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 처음과 마지막 위치를 제외하고 빗물 모으기
        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) left = Math.max(heights[j], left);

            for (int j = i + 1; j < w; j++) right = Math.max(heights[j], right);

            if (heights[i] < left && heights[i] < right) answer += Math.min(left, right) - heights[i];
        }

        System.out.println(answer);
    }
}
