import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int result = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(solution()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solution() {
        Map<Integer, Integer> map = new HashMap<>();
        int startIndex = 0, endIndex = 0;
        int maxLength = 0;

        while (endIndex < N) {
            int item = arr[endIndex];
            map.put(item, map.getOrDefault(item, 0) + 1);

            while (map.get(item) > K) {
                int leftItem = arr[startIndex];
                map.put(leftItem, map.get(leftItem) - 1);
                if (map.get(leftItem) == 0) {
                    map.remove(leftItem);
                }
                startIndex++;
            }

            maxLength = Math.max(maxLength, endIndex - startIndex + 1);
            endIndex++;
        }

        return maxLength;
    }
}
