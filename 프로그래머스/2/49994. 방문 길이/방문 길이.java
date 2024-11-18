import java.io.*;
import java.util.*;

class Solution {

    // 다음 좌표 결정을 위한 해시맵 생성
    private static HashMap<Character, int[]> location = new HashMap<>();
    
    // 좌표평면을 벗어나는지 확인
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx <= 10 && 0 <= ny && ny <= 10;
    }
    
    // 방향에 따른 이동 위치 지정
    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }
    
    public static int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;
        HashSet<String> answer = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int[] dir = location.get(dirs.charAt(i));
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if (!isValidMove(nx, ny)) continue;
            
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            
            x = nx;
            y = ny;
        }
        
        return answer.size() / 2;
    }
}
