import java.util.*;

class Solution {
    static int[] visited = new int[1000001];

    public int solution(int x, int y, int n) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(x);
        visited.add(x);

        if (x == y) return 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == y) return cnt;
                if (cur + n <= y && !visited.contains(cur + n)) {
                    q.add(cur + n);
                    visited.add(cur + n);
                }
                if (cur * 2 <= y && !visited.contains(cur * 2)) {
                    q.add(cur * 2);
                    visited.add(cur * 2);
                }
                if (cur * 3 <= y && !visited.contains(cur * 3)) {
                    q.add(cur * 3);
                    visited.add(cur * 3);
                }
            }
            cnt++;
        }
        return -1;
    }
}