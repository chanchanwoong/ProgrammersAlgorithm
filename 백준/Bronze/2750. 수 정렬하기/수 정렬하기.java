import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < N; i++) {
            System.out.println(q.poll());
        }
    }
}