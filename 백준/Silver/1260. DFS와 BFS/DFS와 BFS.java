import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int V = Integer.parseInt(st.nextToken());

        // 인덱싱 매칭 처리를 위해 노드 개수 + 1
        visited = new boolean[N + 1];
        map = new ArrayList[N + 1];

        // 제네릭 배열을 사용할 수 없어서 직접 생성
        for(int i = 1; i <= N; i++) map[i] = new ArrayList<>();
        
        int node1, node2;

        // 간선 입력 처리
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            map[node1].add(node2);
            map[node2].add(node1);
        }

        // 작은 수의 노드를 먼저 탐색하기 위한 연결 리스트를 오름차순 정렬
        for(int i = 1; i <= N; i++) Collections.sort(map[i]);

        dfs(V, bw);
        Arrays.fill(visited, false);
        bfs(V, bw);

        br.close();
        bw.close();
    }

    // 스택을 이용한 dfs
    private static void dfs(int v, BufferedWriter bw) throws IOException {
        Stack<Integer> stack = new Stack<>();
        stack.add(v);

        while(!stack.isEmpty()) {
            int curPoint = stack.pop();

            if(!visited[curPoint]) {
                visited[curPoint] = true;
                bw.write(curPoint + " ");

                // 오름차순 정렬된 리스트에서 작은 원소를 먼저 나오게 진행
                for(int i = map[curPoint].size() - 1; i >= 0; i--) {
                    // 큰 것 먼저 stack에 넣어야 작은 원소가 먼저 진행(후입선출)
                    int nextPoint = map[curPoint].get(i);

                    if(!visited[nextPoint]) stack.push(nextPoint);
                }
            }
        }

        bw.write("\n");
        bw.flush();
    }

    private static void bfs(int v, BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int curPoint = queue.poll();
            bw.write(curPoint + " ");

            for(int nextPoint : map[curPoint]) {
                if(!visited[nextPoint]) {
                    visited[nextPoint] = true;
                    queue.add(nextPoint);
                }
            }
        }
        bw.flush();
    }
}