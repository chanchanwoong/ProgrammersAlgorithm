import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> processes = new ArrayList<>();
        // key 인덱스, value 우선순위 값
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        // HashMap에 인덱스와 우선순위 값 입력
        for(int i=0; i< priorities.length; i++){
            map.put(i, priorities[i]);
            q.offer(i);
        }

        // peek() 검사
        while(!q.isEmpty()){
            int index = q.peek();
            int priority = map.get(index);
            int maxPriority = Collections.max(map.values());

            // 우선순위가 가장 큰 값일 때
            if(priority == maxPriority){
                processes.add(q.poll());
                map.remove(index);
            }
            // 우선순위가 가장 큰 값이 아닐 때,
            else{
                // front에서 빼서 rear로 넣음
                int value = q.poll();
                q.offer(value);
            }
        }

        // location으로 구함
        answer = processes.indexOf(location) + 1;
        return answer;
    }
}