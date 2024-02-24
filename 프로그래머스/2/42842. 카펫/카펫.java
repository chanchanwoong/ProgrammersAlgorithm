class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x=0;  // 가로
        int y=0;  // 세로

        // 관계식 생성
        while(true){
            y++;
            Double xByYellow = (yellow + brown) / (double) y;
            Double xByBrown = (brown - 2*y +4) / 2.0;

            if(Math.abs(xByYellow - xByBrown) < 0.00001){
                answer[0] = (int) Math.round(xByBrown);
                answer[1] = y;
                return answer;
            }
        }
    }
}