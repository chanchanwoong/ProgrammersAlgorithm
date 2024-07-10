import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int item = Integer.parseInt(br.readLine());
            q.add(item);
            sum += item;
        }

        bw.write(String.valueOf(sum / 5));
        bw.write("\n");
        q.poll();
        q.poll();

        bw.write(String.valueOf(q.poll()));

        bw.flush();
        bw.close();
        br.close();
    }
}