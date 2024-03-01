import java.util.*;
class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> s= new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        // p에 값 대입
        for(int i=0; i< progresses.length; i++){
            p.add(progresses[i]);
            s.add(speeds[i]);
        }
        // p가 빌 때 까지 반복
        // p의 첫 값이 100 넘어가면 remove하고 동시에, speed도 remove 해야 함
        while(!p.isEmpty()){
            int cnt = 0;
            // p에 speed에 맞게 값 갱신
            for(int i=0; i<p.size(); i++){
                int newValue = p.get(i) + s.get(i);
                p.set(i, newValue);
            }
            // p의 첫 값 검사
            while(!p.isEmpty() && p.get(0) >= 100){
                    p.remove(0);
                    s.remove(0);
                    cnt++;
            }
            if(cnt > 0){
                answer.add(cnt);
            }
        }
        return answer;
    }
}