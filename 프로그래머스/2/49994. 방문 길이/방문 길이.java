import java.util.*;

class Solution {
    public int solution(String dirs) {
       int answer = 0;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        HashSet set = new HashSet();

        for(int i=0; i<dirs.length(); i++){
            String from = "("+x1+","+y1+")";
            String to = null;

            // 범위를 벗어나면 (x2,y2) = (x1,y2) 되야 한다.
            if(dirs.charAt(i) == 'U' && y1 < 5){
                x2 = x1;
                y2 = y1 + 1;
            }else if(dirs.charAt(i) == 'D' && y1 > -5){
                x2 = x1;
                y2 = y1 - 1;
            }else if(dirs.charAt(i) == 'L' && x1 > -5){
                x2 = x1 - 1;
                y2 = y1;
            }else if(dirs.charAt(i) == 'R' && x1 < 5){
                x2 = x1 + 1;
                y2 = y1;
            }else{
                // 범위를 벗어난 경우 set에 추가안하고 다음 반복으로 넘김
                continue;
            }
            to = "("+x2+","+y2+")";
            set.add(from + "," + to);
            set.add(to + "," + from);
            x1=x2;
            y1=y2;
        }
        answer = set.size() / 2;
        return answer;
    }
}